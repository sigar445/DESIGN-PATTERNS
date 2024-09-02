package org.sigar.JavaCRef12Part1.chap9Interfaces;

public interface StaticMethod {
    int val = 10;
    static int  sayHello(){
        System.out.println("Saying hello from static say HEllo in ");
        return val;
    }

}
