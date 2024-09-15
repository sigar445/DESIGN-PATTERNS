package org.sigar.CollectionStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class ReduceDemo {

    public static void reduceFlatMap() {
        String sentence = "Hello how are you , I am fine";

        List<String> words = Arrays.stream(sentence.split(" ")).toList();
        String reducedString = words.stream()
                .reduce((a,b) -> a+". " +b)
                .get();
        Set<String> wordList = words.stream()
            //.map(word -> word.substring(0,Integer.min(3,word.length())))
                .flatMap(word1-> IntStream.range(0,word1.length())
                             .mapToObj(index -> word1.substring(0,index).toLowerCase()))
                .collect(Collectors.toSet());
        System.out.println(wordList);


               //  System.out.println/(reducedFlatMap);

    }
    public static void reduceProductOfNumbers(){
        List<Integer> list = List.of(4,65,23,45,76);
        int product = list.stream().reduce(1,(a,b)->a*b);
        int maxValue = list.stream().reduce(0, Integer::max);
        System.out.println(product + "  max " + maxValue);
    }
    public static void countLetters(){
        Stream<String> words = Stream.of("Java", "Magazine", "is",
                "the", "best");

        Map<String, Long> letterToCount = new HashMap<>();
//                words.map(w -> w.split(""))
//                        .flatMap(Arrays::stream)
//                        .collect(groupingBy(identity(), counting()));

                 words
                .flatMap(word -> Arrays.stream(word.split("")))
                .forEach(letter -> letterToCount.merge(letter, 1L, Long::sum));
        letterToCount.forEach((k,v)-> System.out.println(k + " :" + v));


        String[] words1 = {"hello", "world", "java"};

        Map<String, Long> letterToCount1 = Arrays.stream(words1)  // Stream<String>
                .flatMap(word -> Arrays.stream(word.split("")))  // Flatten to Stream<String> of characters
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        letterToCount1.forEach((k,v)-> System.out.println(k + " :" + v));

    }
    public static void distinctWordsInFile() throws IOException {
//        Files.lines(Paths.get("stuff.txt"))
//                .map(line -> line.split("\\s+")) // Stream<String[]>
//                .map(Arrays::stream) // Stream<Stream<String>>
//                .distinct() // Stream<Stream<String>>
//                .forEach(System.out::println);

        Files.lines(Paths.get("stuff.txt"))
                .map(line -> line.split("\\s+")) // Stream<String[]>
                .flatMap(Arrays::stream) // Stream<Stream<String>>
                .distinct() // Stream<Stream<String>>
                .sorted()
                .forEach(System.out::println);

    }
    public static void countingTransactions(){
        Stream<Integer> transactions = Stream.of(4,56,67,34,45);
        long howManyTransactions =
                transactions.count();
        System.out.println(howManyTransactions);

        Stream<Integer> transactions1 = Stream.of(4,56,67,34,45);
//        long transactionsTotal = transactions1.mapToLong(Long::valueOf).sum();
//        System.out.println(transactionsTotal);
        int totalValue = transactions1.mapToInt(Integer::intValue).sum(); // Summing up the Integer values
        System.out.println(totalValue);
    }
    public static void averageValues(){
        Stream<Integer> transactions1 = Stream.of(4,56,67,34,45);
        double average = transactions1.collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(average);
    }
    public static void maxAndMin(){
        Stream<Integer> transactions1 = Stream.of(4,56,67,34,45);
         Optional<Integer> maxvalue = transactions1.max(comparing(Integer::intValue));
        System.out.println(maxvalue.get());
        Stream<Integer> transactions2 = Stream.of(4,56,67,34,45);

        Optional<Integer> minvalue = transactions2.min(comparing(Integer::intValue));
        System.out.println(minvalue.get());

        Stream<Integer> transactions3 = Stream.of(4,56,67,34,45);
        int total = transactions3.map(Integer::intValue).reduce(0, Integer::sum);

    }
    public static void main(String[] args) throws IOException {
       // reduceProductOfNumbers();
       // countLetters();
       // distinctWordsInFile();
       //  countingTransactions();
       //  averageValues();
        maxAndMin();
    }
}
