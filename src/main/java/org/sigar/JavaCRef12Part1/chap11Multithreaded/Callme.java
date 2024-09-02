package org.sigar.JavaCRef12Part1.chap11Multithreaded;

public class Callme {
    void call(String msg){
        System.out.print("[ " + msg);
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(" ]");
    }
}
