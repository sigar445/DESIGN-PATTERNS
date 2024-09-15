package org.sigar.Serialization.BookExample;

import java.io.*;

public class SerializationDemo {
    public static void objectSerialization() {
        // Object serialization
        try (ObjectOutputStream objOStrm =
                     new ObjectOutputStream(new FileOutputStream("serial"))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);
            objOStrm.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Exception during serialization: " + e);
        }
        // Object deserialization
        try (ObjectInputStream objIStrm =
                     new ObjectInputStream(new FileInputStream("serial"))) {
            MyClass object2 = (MyClass) objIStrm.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
        }
    }

    public static void objectSerializationWithFilter() {
        String filename = "serialized_object_data";

        // Serialize the object
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream(filename))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("Serialized object1: " + object1);

            // Write object to the file
            objOStrm.writeObject(object1);

        } catch (IOException e) {
            System.out.println("Exception during serialization: " + e.getMessage());
        }

        // Deserialize the object with a filter
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream(filename))) {

            // Create and apply a more flexible deserialization filter
            // Adjusted deserialization filter to allow basic types
            // Assuming MyClass is part of a package like 'com.example'
            ObjectInputFilter filter = ObjectInputFilter.Config.createFilter("java.base/*;org.sigar.Serialization.BookExample.MyClass;!*");

            objIStrm.setObjectInputFilter(filter);

            // Read the object from the file
            MyClass object2 = (MyClass) objIStrm.readObject();
            System.out.println("Deserialized object2: " + object2);

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization: " + e.getMessage());

        } catch (InvalidClassException e) {
            System.out.println("Invalid class during deserialization: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IO Exception during deserialization: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        objectSerializationWithFilter();
    }
}
