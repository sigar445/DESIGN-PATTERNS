package org.sigar.JavaCRef12Part1.chap6Classes;

public class _Static {
    //Static objects are loaded first when class is loaded
    static int a = 3;
    static int b;
    static{
        a = 4;
        b = 4*a;
        System.out.println("Static block initialized");
    }

    public static void main(String[] args) {
            System.out.println(b);
    }
}
