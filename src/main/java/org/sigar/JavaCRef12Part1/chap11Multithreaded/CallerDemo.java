package org.sigar.JavaCRef12Part1.chap11Multithreaded;

public class CallerDemo {
    public static void main(String[] args) {

        Callme callme = new Callme();

        Caller caller1 = new Caller("Hello ",callme);
        Caller caller2 = new Caller("Hixcvxv",callme);
        Caller caller3 = new Caller("Hsdfo",callme);


        caller1.t.start();
        caller2.t.start();
        caller3.t.start();

        try {
            caller1.t.join();
            caller1.t.join();
            caller1.t.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
