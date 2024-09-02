package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class ToArrayDemo {
    public static void main(String[] args) {
        functionToArray();
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");


        //New Array creation if given null or smaller size array given
        String[] array = list.toArray(new String[0]);

       Arrays.stream(array).forEach(System.out::println);

        List<String> newList = new ArrayList<>();
        newList.add("Apple");
        newList.add("Banana");
        newList.add("Orange");

        //New array creation if smaller size array is given
        String[] smallSizeArray = new String[2];
        smallSizeArray[0] = "First";

        String[] copyList = newList.toArray(smallSizeArray);

        Arrays.stream(copyList).forEach(System.out::println);
        Arrays.stream(smallSizeArray).forEach(System.out::println);

        //Copying array if equal size array is given
        String[] equalSizeArray = new String[newList.size()];
        equalSizeArray[1] = "Hello";
        newList.toArray(equalSizeArray);
        Arrays.stream(equalSizeArray).forEach(System.out::println);
//
//        String[] noArgsStringArray = (String[]) newList.toArray();
//
//        Object[] noArgsArray = newList.toArray();
//        Arrays.stream(noArgsArray).forEach(System.out::println);


    }
    static void functionToArray(){

        ArrayList<Double> doubleArrayList = new ArrayList<>();
        doubleArrayList.add(1.1);
        doubleArrayList.add(2.2);
        doubleArrayList.add(3.3);
        //  System.out.println(doubleArrayList);

        // Custom array generation function
        IntFunction<Double[]> customArrayGen = size -> new Double[size];

        // Convert ArrayList to Double array using custom array generator
        Double[] doubleArray = doubleArrayList.toArray(customArrayGen);
        System.out.println(doubleArray);

        // Print the array
        for (Double d : doubleArray) {
            System.out.println(d);
        }
    }
}
