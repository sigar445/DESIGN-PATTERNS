package org.sigar.JavaCRef12Part1.chap13_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferedReaderDemo {
        public static void main(String[] args) throws IOException {
            readNLines();
          System.out.println("Program terminated.");
        }

        static public void readLine() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = "-1";
            while(!line.equalsIgnoreCase("quit")){
                line = br.readLine();
                System.out.println(line);
            }

        }
        static public void readChars() throws IOException{
            char c = 'a';
            java.io.BufferedReader br = new java.io.BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter characters (enter 'q' to quit):");

            while (c != 'q') {
                c = (char) br.read();
                if (c != '\n') { // To avoid printing the newline character
                    System.out.println("You entered: " + c);
                }
            }

        }
        static public void readNLines() throws IOException {
            Scanner scanner= new Scanner(System.in);
            int N = 0;
            do {
                System.out.print("Enter an integer in range of 1-10 : ");
                if (scanner.hasNextInt() ) {
                    N = scanner.nextInt();
                    break; // Valid integer, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter an integer in range");
                    scanner.next(); // Consume the invalid input
                }
            } while (true);

            System.out.println("You entered: " + N);
            N = Math.min(10,N);
            String[] str = new String[N];
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (int ind = 0; ind < N; ind++) {
                str[ind] = br.readLine();
                if(str[ind].equalsIgnoreCase("quit")) break;
            }
            for (int ind = 0; ind < N; ind++) {
                if(str[ind].equalsIgnoreCase("quit")) break;
                System.out.println(str[ind]);
            }
            scanner.close();
            br.close();
        }
}

