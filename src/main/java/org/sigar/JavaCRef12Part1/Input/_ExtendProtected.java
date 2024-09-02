package org.sigar.JavaCRef12Part1.Input;

import org.sigar.JavaCRef12Part1.chap6Classes._Protected;

public class _ExtendProtected  extends _Protected {


    public _ExtendProtected(int protectedVal) {
        super(protectedVal);
    }

    public static void main(String[] args) {
        _ExtendProtected val =  new _ExtendProtected(34);
        System.out.println(val.protectedVal);
    }

}
