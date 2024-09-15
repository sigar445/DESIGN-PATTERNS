package org.sigar.InputOutput;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class InputStreamDemo {


    public static void inputStreamMethods(String fileName) throws IOException {
      //  InputStream  inputStream = new BufferedInputStream(new FileInputStream(fileName));
        try(InputStream  inputStream = new FileInputStream(fileName)) {
            System.out.println(inputStream.available());
            byte[] readBytes = inputStream.readNBytes(40);
            System.out.println(new String(readBytes, StandardCharsets.UTF_8));
            System.out.println(inputStream.available());
        }

    }

    public static void main(String[] args) throws IOException {
        String stuff = "stuff.txt";
        inputStreamMethods(stuff);
    }
}
