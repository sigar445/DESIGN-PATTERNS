package org.sigar.Generics.GenericMethod;

public class Maximum {

    public  static <T extends Comparable<T>> T compareVals(T first, T second, T third){
        T max  = first;
        if(second.compareTo(max) > 0) max = second;
        if(third.compareTo(max) > 0) max = third;
        return max;
    }

    public static void main(String[] args) {
      //  Maximum max = new Maximum();
        System.out.println(compareVals(3,4,5));
        System.out.println(compareVals(3.4,43.2,343.4));
        System.out.println(compareVals("qSdfs","sdfsd","atsdfsdfsd"));

    }
}
