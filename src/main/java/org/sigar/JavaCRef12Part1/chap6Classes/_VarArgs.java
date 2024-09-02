package org.sigar.JavaCRef12Part1.chap6Classes;

import java.util.Arrays;

public class _VarArgs {

    static void vaTest(int... val){
        System.out.println(val.length);

        Arrays.stream(val).forEach(System.out::println);

    }

    public static void main(String[] args) {
        vaTest(34,34,435,435,354);
    }
}
