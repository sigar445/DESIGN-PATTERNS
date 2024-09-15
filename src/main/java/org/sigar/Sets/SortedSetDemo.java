package org.sigar.Sets;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

    public static void sortedSetMethods(){
        List<Integer> numbers = List.of(45,34,23,6,37,34,44,62,4,24);
        SortedSet<Integer> sortedSet = new TreeSet<>(numbers);
        System.out.println(sortedSet.headSet(40));
    }
    public static void headAndTailSetMethods(){
        List<Integer> numbers = List.of(45,34,23,6,37,34,44,62,4,24);
        SortedSet<Integer> sortedSet = new TreeSet<>(numbers);
        System.out.println(sortedSet.tailSet(40));
        System.out.println(sortedSet.subSet(20,40));
    }
    public static void main(String[] args) {
        sortedSetMethods();
        headAndTailSetMethods();
    }
}
