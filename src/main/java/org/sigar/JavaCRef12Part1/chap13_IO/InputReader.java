package org.sigar.JavaCRef12Part1.chap13_IO;

import java.io.IOException;
import java.io.InputStream;

public class InputReader {
        public static void main(String[] args) throws IOException {
            char c = 'a';
            InputStream in = System.in;

            System.out.println("Enter characters (enter 'q' to quit):");

            while (c != 'q') {
                int input = in.read(); // Reads the next byte of data from the input stream
                if (input != -1) { // Check if the end of the stream has been reached
                    c = (char) input;
                    if (c != '\n' && c != '\r') { // Avoid printing newline or carriage return
                        System.out.println("You entered: " + c);
                    }
                }
            }

            System.out.println("Program terminated.");
        }


}
