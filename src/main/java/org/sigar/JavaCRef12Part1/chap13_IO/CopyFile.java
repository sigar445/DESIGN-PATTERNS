package org.sigar.JavaCRef12Part1.chap13_IO;

import java.io.*;
import java.util.Scanner;

public class CopyFile {

    public static void main(String[] args) {
        createCopy();
    }
    static void createCopy(){

        Scanner sc =  new Scanner(System.in);
        String original = sc.next();

        File  file = new File(original);
        if(!file.exists()){
            System.out.println("File doesn't exit " + file.getAbsolutePath());
            return;
        }
        try(FileInputStream fin = new FileInputStream(file);
                FileOutputStream fot = new FileOutputStream(original+"Copy")) {
            int i;
            while((i = fin.read()) != -1) {
                fot.write(i);
                System.out.print((char) i);
            }
        }catch (IOException e){
            System.out.println("Caught exception " + e.getCause());
        }
    }

}
