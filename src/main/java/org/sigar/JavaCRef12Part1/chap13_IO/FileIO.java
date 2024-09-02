package org.sigar.JavaCRef12Part1.chap13_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {

    public static void main(String[] args) throws FileNotFoundException {

        readFile();

    }

    static public void readFile()   {
        System.out.print("Enter the file name (with path if not in the current directory): ");

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File file  = new File(fileName);
        if (!file.exists()){
            System.out.println("File does not exist." + file.getAbsolutePath());
            return;
        }
        try( FileInputStream fin  = new FileInputStream(file)){
            int i;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
        } catch(IOException e) {
            System.out.println("Error Closing File");
        }

    }
    static public boolean checkFile(String fileName) throws FileNotFoundException {
        File file  = new File(fileName);
        boolean flag = false;
        if (file.exists()) {
            flag = true;
        } else {
            System.out.println("File does not exist."
                    + file.getAbsolutePath());
        }
        return flag;

    }
}
