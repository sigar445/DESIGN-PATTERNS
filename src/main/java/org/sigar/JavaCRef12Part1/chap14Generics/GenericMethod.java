package org.sigar.JavaCRef12Part1.chap14Generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericMethod {

    static <T extends Comparable<T>,V extends T> boolean isMember(T[] t, V v){
        return Arrays.binarySearch(t,v)>=0;
    }

    public static void main(String[] args) {
        Integer[] intVals = {3,4343,43534,23234,5,645,62,3234,565,345};
        int val = 3;
        String s = "234";
        System.out.println(val +"  is member " + isMember(intVals,val));





    }

}
