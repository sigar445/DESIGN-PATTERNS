package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");
        addMethods(list);

    }
    public static void addMethods(LinkedList<String> list){
        Collection<String> addCollection = Arrays.asList("Hello","Hi","Here");
        LinkedList<String> addList = new LinkedList<>(list);
        addList.add(3,"ThreeADD");
        System.out.println(addList.get(3));
        addList.addAll(1,addCollection);
      //  addList.forEach(System.out::println);
        for (int ind = 0; ind < 5; ind++) {
            System.out.println(ind + " :: " +addList.get(ind));
        }
        list.addFirst("FirstADD");
        list.addLast("LastADD");
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));
    }
}
