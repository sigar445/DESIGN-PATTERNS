package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.Iterator;

public class CollectionInfDemo {
    public static void main(String[] args) {
        CollectionInf<String> collection = new CollectionInf<>(6);

        collection.add("Hello");

        collection.add("I");
        collection.add("Am");
        collection.add("Here");
        collection.add(":::");
        collection.forEach(System.out::println);
        collection.remove("I");
        collection.forEach(System.out::println);

           Iterator<String> iterator = collection.iterator();
         while(iterator.hasNext()) System.out.println(iterator);
    }
}
