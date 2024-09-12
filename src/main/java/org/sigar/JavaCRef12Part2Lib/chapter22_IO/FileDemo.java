package org.sigar.JavaCRef12Part2Lib.chapter22_IO;

import java.io.*;

import static java.lang.Thread.sleep;

public class FileDemo {
    static void p(String s){
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException,InterruptedException {
        parentDirectoryFile();
        fileWrite();
        fileWriteCurrDir();
    }

    static void fileUtils(){
        File f1 = new File("java/Hello");
        System.out.println(f1.getAbsolutePath());

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
    }
    static void parentDirectoryFile() throws IOException {
        File parentDir = new File("..");
        File file = new File(parentDir, "example_parent.txt");

        // Create the file if it doesn't exist
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getAbsolutePath());
        } else {
            System.out.println("File already exists: " + file.getAbsolutePath());
        }
    }

    static void fileWrite() throws IOException {
        File file = new File("example.txt");
       try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter)){
            buffWriter.write("Hello , File is ready to write\n");
            buffWriter.write("Sentence 1\n");
            buffWriter.write("Sentence 2");
        }catch (IOException e){
           e.printStackTrace();
       }
    }
    static void fileWriteCurrDir() throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        String packageName = FileDemo.class.getPackage() == null ? " ": FileDemo.class.getPackageName();

        System.out.println(currentDir + "  currentDir  packageName  " + packageName);

        // Convert the package firstName to a path (e.g., "com.example" -> "com/example")
        String packagePath = packageName.replace('.', File.separatorChar);

        // Combine the current directory with the package path
        File packageDir = new File(currentDir, packagePath);
        packageDir.mkdirs();

        System.out.println("PackageDir " + packageDir + "  packageName " + packageName);

        // Specify the file firstName within the package directory
        File file = new File(packageDir, "exampleCurr5.txt");
        sleep(1000);

        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter)){
            buffWriter.write("Hello , File is ready to write\n");
            buffWriter.write("Sentence 1\n");
            buffWriter.write("Sentence 2\n");
            buffWriter.write("Sentence 3\n");
            buffWriter.write("Sentence 4\n");
            buffWriter.write("Sentence 5\n");
            buffWriter.write("Sentence 6\n");
            buffWriter.write("Sentence 7");

            System.out.println(file.getAbsolutePath());

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(file.renameTo(new File(packageDir,"ExampleCopy2")));
        file.deleteOnExit();
    }


}
