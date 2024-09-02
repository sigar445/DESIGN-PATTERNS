package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {

    public static void main(String[] args) {
        List<Number> numberList = Arrays.asList(3,43,454,3242,324);

        Spliterator<Number> numberSpliterator = numberList.spliterator();
        numberSpliterator.trySplit();
        numberSpliterator.forEachRemaining(System.out::println);
    }
}
