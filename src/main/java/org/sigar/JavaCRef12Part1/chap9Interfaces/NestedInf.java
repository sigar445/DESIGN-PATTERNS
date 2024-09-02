package org.sigar.JavaCRef12Part1.chap9Interfaces;

public class NestedInf implements NestedInterface.nesInf{
    @Override
    public boolean isNegative(int x) {
        return false;
    }

    public static void main(String[] args) {
        NestedInterface.nesInf nesInf = p->{
            System.out.println(p);
            return false;
        };
        nesInf.isNegative(934);

    }
}
