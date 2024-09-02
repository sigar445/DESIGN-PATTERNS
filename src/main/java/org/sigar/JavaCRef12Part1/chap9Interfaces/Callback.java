package org.sigar.JavaCRef12Part1.chap9Interfaces;

public interface Callback {
    public void callback(int param);
    default void defaultMethod(){
        System.out.println("Default method Callback");
    }
}
