package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.Comparator;

public class CustomComparator<T> implements Comparator<CustomComparable<T>> {
    @Override
    public int compare(CustomComparable<T> o1, CustomComparable<T> o2) {
        return Double.compare(o1.getVal(),o2.getVal());
    }
}
