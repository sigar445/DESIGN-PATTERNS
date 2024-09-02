package org.sigar.JavaCRef12Part1.chap6Classes;

public class _Object {
    public static void main(String[] args){
        Object object = new Object();

        System.out.println(object.toString());
        System.out.println(object.hashCode());
        System.out.println(object.getClass());
    }
}
