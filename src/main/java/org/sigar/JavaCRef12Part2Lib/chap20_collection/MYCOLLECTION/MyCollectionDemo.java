package org.sigar.JavaCRef12Part2Lib.chap20_collection.MYCOLLECTION;

import java.util.Arrays;
import java.util.Collection;

public class MyCollectionDemo {
    static  final Collection<String> mycollection = new MyCollection<>(10);

    public static void main(String[] args) {
        // addAndAddAllTest();
        addData();
        parallelStream();
    }
    public static void addData(){
        mycollection.add("Hello");
        mycollection.addAll(Arrays.asList("How","are","you"));

        mycollection.addAll(Arrays.asList("How","are","you"));

        mycollection.addAll(Arrays.asList("How","are","you"));
        mycollection.addAll(Arrays.asList("How","are","you"));
        mycollection.addAll(Arrays.asList("How","are","you"));
    }
    public static void parallelStream(){
        System.out.println(mycollection.parallelStream().isParallel());

    }
    public static void addAndAddAllTest(){

        mycollection.add("Hello");
        mycollection.addAll(Arrays.asList("How","are","you"));

        mycollection.addAll(Arrays.asList("How","are","you"));

        mycollection.addAll(Arrays.asList("How","are","you"));
        mycollection.addAll(Arrays.asList("How","are","you"));
        mycollection.addAll(Arrays.asList("How","are","you"));

        mycollection.forEach(System.out::println);
    }
}
