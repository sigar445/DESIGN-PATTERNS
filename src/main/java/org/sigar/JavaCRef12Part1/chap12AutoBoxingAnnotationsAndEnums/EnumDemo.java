package org.sigar.JavaCRef12Part1.chap12AutoBoxingAnnotationsAndEnums;

public class EnumDemo {
    enum Apples{RED,BROWN,WINESAP,NAGPUR}

    public static void main(String[] args) {
        Apples ap;
        Apples[] apples = Apples.values();
        for(Apples a:apples)
            System.out.println(a);
        System.out.println(Apples.valueOf("RED"));
    }
}
