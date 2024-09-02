package org.sigar.JavaCRef12Part1.chap9Interfaces;


public class Client implements Callback,Tester {

    public void callback(int p){
        System.out.println("Callback called with " + p);
    }

    public void checkCall(){
        System.out.println("Check call in Client");

    }

    @Override
    public void test() {
        System.out.println("Tester method in client");
    }
}
