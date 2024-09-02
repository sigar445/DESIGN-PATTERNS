package org.sigar.JavaCRef12Part2Lib.chapter22_IO;

import java.io.*;

public class FlushableDemo {

    public static void main(String[] args) throws IOException {
        flush("flush.txt");
    }
    public static void flush(String fileName) throws IOException {
        File curr_dir = FileDirDemo.getCurrentDir();
        File writeble_file = new File(curr_dir,fileName);
        try(BufferedWriter writer =  new BufferedWriter(new FileWriter(writeble_file))){
            writer.write("Hello, world! ");
            writer.newLine();
            writer.write("I am here, look out");
            writer.flush();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        System.out.println(writeble_file.getAbsolutePath());
    }

}
