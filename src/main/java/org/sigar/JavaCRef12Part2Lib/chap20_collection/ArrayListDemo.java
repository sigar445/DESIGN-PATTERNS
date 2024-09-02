package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");

        list.add("Hi");
        list.add("Fun");
        list.add("Walk");
        list.add("And");
        list.add("And");

        Collection<String> removeList = Arrays.asList("Fun","And");
        list.removeAll(removeList);
        list.forEach(System.out::println);

        List<String> copyList = new ArrayList<>(removeList);
        copyList.forEach(System.out::println);




    }
}
