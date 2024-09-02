package org.sigar.JavaCRef12Part1.chap2Variables;

public class _Scope {
    public static void main(String[] args) {
        int x = 3;
        for (int ind = 0;ind< 34;ind++){
        //    int x = 5;  illegal
            x++;
        }
    }
}
