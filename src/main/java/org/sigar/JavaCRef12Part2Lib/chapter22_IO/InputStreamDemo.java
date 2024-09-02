package org.sigar.JavaCRef12Part2Lib.chapter22_IO;

import java.io.*;

public class InputStreamDemo {

    public  static void main(String[] args) {
        //fileInputStreamDemo();

    }
}
//    static void fileInputStreamDemo(){
//        File  file = FileDirDemo.getCurrentDir();
//        File exFile = new File(file,"flush.txt");
//        try(FileInputStream fis = new FileInputStream(exFile)){
//            int data;
//            while((data = fis.read()) != -1){
//                System.out.print((char) data);
//            }
//
//        }catch (IOException e) {
//            e.printStackTrace();
//            //  throw new RuntimeException(e);
//        }
//    }
//    static void inputStream() throws IOException {
//        try(InputStream streamDemo = new InputStream() {
//            private  int counter = 0;
//            private final byte[] data = {1, 2, 3, 4, 5};
//            @Override
//            public int read(){
//                if(counter < data.length){
//                    return data[counter++];
//                }else{
//                    return -1;
//                }
//            }){
//            int byteRead;
//            while((byteRead = streamDemo.read()) != 1 ) System.out.println(byteRead);
//            };
//        };}
