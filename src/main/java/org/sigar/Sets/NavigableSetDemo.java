package org.sigar.Sets;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {

    public static void navigableSetMethods(){
        NavigableSet<Integer> navigableSet = new TreeSet<>(List.of(45,34,6,37,34,44,62,4,24));
//        Summary of Behaviors:
//        floor(): Finds the largest element ≤ the given element.
//        ceiling(): Finds the smallest element ≥ the given element.
//        higher(): Finds the smallest element strictly > the given element.
//        lower(): Finds the largest element strictly < the given element.
//                These methods are especially useful when you need to locate elements
        // navigableSet.descendingIterator().forEachRemaining(System.out::println);
        System.out.println(navigableSet.floor(23));
        System.out.println(navigableSet.ceiling(23));
        System.out.println(navigableSet.higher(23));
        System.out.println(navigableSet.lower(23));

        System.out.println(navigableSet.subSet(24,40));
        System.out.println(navigableSet.pollFirst());

    }

    public static void main(String[] args) {
        navigableSetMethods();
    }
}
