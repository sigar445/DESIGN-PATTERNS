package org.sigar.JavaCRef12Part2Lib.chap21_java_util;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class OptionalDemo {

    public static void main(String[] args) {
            //mapAndFlatMap();
            //mapImp();
            filterEx();
    }
    static void filterEx(){
//        Optional<String> empty = Optional.of("Hello");
//        System.out.println(empty.get());
//        System.out.println(empty.isEmpty());
//        Predicate<String> p = z -> z.startsWith("W");
//        Optional<String> filterH = empty.filter(val -> val.startsWith("H"));
//        if(filterH.isPresent()) System.out.println(filterH.get());
//        filterH = empty.filter(p);
//        if(filterH.isPresent()) System.out.println(filterH.get());
        Optional<String> opt = Optional.of("Hello");
        opt.ifPresentOrElse(System.out::println,()-> System.out.println("Empty Value"));

        opt = Optional.empty();
        opt.ifPresentOrElse(System.out::println,()-> System.out.println("Empty Value"));
    }

    static void FlatMapImp(){
        Optional<String> optionalString = Optional.of("1f23");
        // Function to parse the string into an Optional<Integer>
        Optional<Integer> optionalInteger = optionalString.flatMap(str -> {
            try {
                return Optional.of(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        });
        System.out.println(optionalInteger.orElseGet(()->-1));
    }
    static void mapImp(){
        Optional<String> optionalString = Optional.of("1f23");
        // Function to parse the string into an Optional<Integer>
        Optional<Integer> optionalInteger = optionalString.map(str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return -1;
            }
        });
        System.out.println(optionalInteger.orElseGet(()->-1));
    }

}
