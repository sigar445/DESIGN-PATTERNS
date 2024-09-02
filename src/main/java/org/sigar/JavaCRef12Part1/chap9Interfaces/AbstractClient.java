package org.sigar.JavaCRef12Part1.chap9Interfaces;

abstract class AbstractClient implements Tester{
    public static void main(String[] args) {
        System.out.println(343);
    }
    public void sayHello(){
        System.out.println("Saying hello from abstract Client");
    }
}
