package org.sigar.File;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileDemo {

    public static void fileMethods(String directory, String filename){
        File directoryFile = new File(directory);
//        System.out.println(directoryFile.isFile() ? "Is a directoryFile" : "No idea");
//        System.out.println(directoryFile.isDirectory() ? "Is a Directory":"No idea");
//        System.out.println(directoryFile.toURI());

        if(directoryFile.isDirectory()){
           // Arrays.stream(Objects.requireNonNull(directoryFile.list())).forEach(System.out::println);
            File[] onlyFiles = directoryFile.listFiles(File::isFile);
            Arrays.stream(onlyFiles).forEach(System.out::println);
            System.out.println();
            System.out.println("Printing directories");
            Arrays.stream(directoryFile.listFiles(File::isDirectory)).forEach(System.out::println);

            System.out.println();
            System.out.println("Printing all that contains the char s");

            String[] filesWithCharS = directoryFile.list((direct,fileN)-> fileN.contains("s"));
            Arrays.stream(filesWithCharS).forEach(System.out::println);


            System.out.println("Printing files with size less than 50");
            File[] filesWithSmallSize = directoryFile.listFiles(s -> s.isFile() && s.length() < 50);
            Arrays.stream(filesWithSmallSize).forEach(System.out::println);



        }


//        File file = new File(directory,filename);
//        System.out.println(file.isFile() ? "Is a File" : "No idea");
//        System.out.println(file.isDirectory() ? "Is a Directory":"No idea");
//        System.out.println(file.toURI());



    }
    public static void fileAttributes(String fileName) {
        File f1 = new File(fileName);
        p("File Name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Abs Path: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());
        p(f1.exists() ? "exists" : "does not exist");
        p(f1.canWrite() ? "is writeable" : "is not writeable");
        p(f1.canRead() ? "is readable" : "is not readable");
        p("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
        p(f1.isFile() ? "is normal file" : "might be a named pipe");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("File last modified: " + f1.lastModified());
        p("File size: " + f1.length() + " Bytes");

    //   p(String.valueOf(f1.renameTo(new File("test.text"))));
       p(String.valueOf(f1.delete()));

    }
    static void p(String s) {
        System.out.println(s);
    }
    public static void main(String[] args) {
        //   fileMethods(".","stuff.txt");
        fileAttributes("hello");
    }
}
