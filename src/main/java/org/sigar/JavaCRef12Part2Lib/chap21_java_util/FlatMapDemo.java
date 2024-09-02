package org.sigar.JavaCRef12Part2Lib.chap21_java_util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlatMapDemo {

    public static void main(String[] args) {

        //flapMapEx();
        // flatMapOnList();
        flatMapPair();
    }


    static void flapMapEx() {
//        Optional<String> opt = Optional.of("Hello");
//
//
//        Optional<Integer> flatMappedOpt = opt.flatMap(val -> Optional.of(val.length()));
        Optional<String> opt = Optional.of("Hello");
        Function<String, Optional<Integer>> lengthMapper = s -> Optional.of(s.length());

// Flat map the condition to get the final Optional<Integer>
        Optional<Integer> flatMappedOpt = opt.flatMap(lengthMapper);

        System.out.println(flatMappedOpt.get()); // Output: 5
    }

    static void flatMapOnList() {
        List<Double> doubleList = Arrays.asList(34.3d, 343d, 343d, 3434d, 343d);

        Function<Double, Double> f = val -> val + 5;
//        Consumer<Double> consumer = c -> c  = c + 5;
//        doubleList.forEach(consumer);
//        doubleList.forEach(System.out::println);

        List<Double> increasedList = doubleList.stream().map(f).toList();
        increasedList.forEach(System.out::println);

        List<String> words = Arrays.asList("Life is Good", "Hello is it okay", "We are in a bubble");
        Set<String> word = words.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toSet());
        System.out.println(word);
    }

    static void flatMapPair() {
        List<String> colors = Arrays.asList("Blue", "Brown", "White", "Pink");
        List<String> animals = Arrays.asList("Dog", "Cat", "Whale", "Bird");

        colors.stream().flatMap(c -> animals.stream().map(animal -> c + " " + animal))
                .forEach(System.out::println);
    }
}


