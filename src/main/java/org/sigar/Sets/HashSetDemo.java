package org.sigar.Sets;

import java.util.*;
import java.util.stream.IntStream;

public class HashSetDemo {
    public static void hashSetVariations() {
        List<String> val = List.of("Hello","how","are","You");
        String s = "I am fine";
        List<String> list = Arrays.stream(s.split(" ")).
                toList();

        // Unordered Insert , 0(1) for add and remove
        Set<String> set = new HashSet<>(val);
        addValsAndPrint(set,val);
        addValsAndPrint(set,list);

        // Sorted Insert log(n) order for add , get , remove
        Set<String> treeSet = new TreeSet<>(String::compareToIgnoreCase);
        treeSet.addAll(val);
        addValsAndPrint(treeSet,list);

        // Ordered Insert , remembers insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>(val);
        addValsAndPrint(linkedHashSet,list);

      //  String[] values = set.toArray(new String[0]);




    }

    public static<T> void addValsAndPrint(Set<T> set,List<T> vals){
        set.addAll(vals);
        set.forEach(s -> System.out.print(s + " "));
        System.out.println();

    }
    public static void addValsAndPrint(Set<Integer> set){
        IntStream.rangeClosed(1,5).forEach(set::add);
        set.forEach(System.out::println);

    }

    public static void main(String[] args) {
        hashSetVariations();
    }
}