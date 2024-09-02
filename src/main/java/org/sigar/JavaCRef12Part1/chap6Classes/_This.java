package org.sigar.JavaCRef12Part1.chap6Classes;

import org.sigar.JavaCRef12Part1.Input._ExtendProtected;

public record _This(String name) {

    public static void main(String[] args) {

        _ExtendProtected val =  new _ExtendProtected(34);
        System.out.println(val.protectedVal);
    }
}
