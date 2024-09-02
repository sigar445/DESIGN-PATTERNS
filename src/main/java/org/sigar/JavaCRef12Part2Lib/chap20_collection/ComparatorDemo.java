package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {

        List<CustomComparable<String>> list = Arrays.asList(
                new CustomComparable<>(3.4,"First"),
                new CustomComparable<>(1.4,"Second"),
                new CustomComparable<>(4.4,"Third"),
                new CustomComparable<>(7.4,"Fourth")
        );
        Collections.sort(list);
        list.forEach(System.out::println);
        Comparator<CustomComparable<String>> compMY = (f,s)->f.getGenericVal().compareTo(s.getGenericVal());

        Comparator<CustomComparable<String>> compSys = Comparator.comparing(CustomComparable::getGenericVal);
        list.sort(compMY);
        list.forEach(System.out::println);

        System.out.println("Printing custom comparator values");
        list.sort(new CustomComparator<>());
        list.forEach(System.out::println);


    }
}
