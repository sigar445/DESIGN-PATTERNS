package org.sigar.CustomStreams;

import java.io.*;

public class CustomFISDemo {
    public static void upperCaseFISCheck() {
        String filename = "helloCopy";

        try (InputStream fileInputStream = new FileInputStream(filename);
             InputStream uppercaseStream = new UpperCaseFIS(fileInputStream)) {

            int data;
            byte[] tenBytes = new byte[10];
            // uppercaseStream.mark(100);
            int val = uppercaseStream.read(tenBytes, 0, 10);
            System.out.println(new String(tenBytes));
            //  uppercaseStream.reset();

            // Read and display the uppercase converted content
            while ((data = uppercaseStream.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void upperCaseFOSCheck(String fileName) throws FileNotFoundException {
        try(OutputStream fileOutputStream = new FileOutputStream(fileName);
            OutputStream upperCaseFOS = new UpperCaseFOS(fileOutputStream)) {
            String str = " Hello check me and write me to file";
            byte[] strBytes = str.getBytes();
            upperCaseFOS.write(strBytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        upperCaseFOSCheck("customStreamDemo");
    }
}

