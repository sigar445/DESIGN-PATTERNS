package org.sigar.InputOutput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class BufferedInputStreamDemo {
    public static void bufferedInputStreamMarkAndReset(String fileName) throws IOException {

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            System.out.println(inputStream.available());
            byte[] readBytes = inputStream.readNBytes(40);
            System.out.println(new String(readBytes, StandardCharsets.UTF_8));
            inputStream.mark(100);
            System.out.println("////");
            for (int i = 0; i < 5; i++) {
                System.out.print((char) inputStream.read());
            }
            System.out.println(inputStream.available());
            System.out.println("/////");


            readBytes = inputStream.readNBytes(10);
            System.out.println(new String(readBytes, StandardCharsets.UTF_8));
            System.out.println(inputStream.available());
            inputStream.reset();
            System.out.println("////");
            for (int i = 0; i < 5; i++) {
                System.out.print((char) inputStream.read());
            }
            System.out.println(inputStream.available());
            System.out.println("/////");

        }
    }
        public static void main(String[] args) throws IOException {
        String stuff = "stuff.txt";
        bufferedInputStreamMarkAndReset(stuff);
    }
}
