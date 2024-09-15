package org.sigar.Serialization;
import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object in the RMI registry
            PersonService personService = (PersonService) Naming.lookup("rmi://localhost/PersonService");

            // Call the remote method and get the Person object
            Person person = personService.getPerson();

            // The object is deserialized on the client-side and used here
            System.out.println("Received person: " + person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}