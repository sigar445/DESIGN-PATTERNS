package org.sigar.JavaCRef12Part1.chap9Interfaces;
public class AnotherClient implements Callback {

    public void callback(int p){
        System.out.println("Another client's Callback in " + p);
    }

}
