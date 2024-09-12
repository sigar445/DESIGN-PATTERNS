package org.sigar.JavaCRef12Part2Lib.chap20_collection.MyDeque;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyDeque {
    private static Deque<String> getSampleDeque(){
        Deque<String> stringDeque  = new ArrayDeque<>();
        String[] values = {"HEllo","Hi","are","you"};
        Arrays.stream(values).forEach(stringDeque::addLast);
        stringDeque.addAll(List.of("why", "not", "displined"));
        String[] addValues = new String[]{"Why","not","in","shape"};
        stringDeque.addAll(List.of(addValues));
        return stringDeque;
    }
    public static void checkDequeAddMethods(){
        Deque<String> stringDeque  = getSampleDeque();
        //while (!stringDeque.isEmpty()) System.out.println(stringDeque.pollLast());
      //  stringDeque.stream().peek(val -> System.out.println("Peek val is " + val)).forEach(System.out::println);
        String[] combinedStrings = stringDeque.toArray(new String[0]);
        System.out.println(Arrays.toString(combinedStrings));
    }
    public static void printArrays(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
    public static void dequeStreamOperations(){
        Deque<String> stringDeque  = getSampleDeque();
        stringDeque.stream().mapToInt((String::length)).forEach(System.out::println);
        stringDeque.stream().map(s -> s.concat("_count")).forEach(System.out::println);

        int[] arrayVals = stringDeque.stream().map(s -> s.length()*3).mapToInt(Integer::valueOf).toArray();
        stringDeque.stream().map(s -> s.length() > 3 ? "Long String" : "Short String").forEach(System.out::println);
        printArrays(arrayVals);


        
    }

    public static void flatMapAndCustomMapping() {
        List<String> deque = List.of("Hello World", "How are you", "Is it fine");
        List<Person> set = deque.stream().flatMap(s -> Arrays.stream(s.split(" ")))
                .map(s -> new Person(s,s.length()))
                .toList();
        for (Person val : set) {
            System.out.println(val + " ");
        }
        System.out.println();
    }
    public static void filterOperations(){
        Deque<String> deque = getSampleDeque();
//        Predicate<String> contains_HY = s-> s.contains("hy");
//        deque.stream().filter(contains_HY).forEach(System.out::println);

        String vowels = "aeiouAEIOU";
        System.out.println(vowels.indexOf('c'));
        Predicate<String> checkStartsWithVowel = s-> vowels.indexOf(s.charAt(0)) != -1;
        deque.stream().filter(checkStartsWithVowel).forEach(System.out::println);
    }
    public static void offerOperations(){
        Deque<String> deque = getSampleDeque();
        //similar to add , but check capacity and offerlast is same
     //   System.out.println(deque.offer("dsfd"));
        deque.offerFirst("first");
        deque.offerLast("last");
        deque.forEach(System.out::println);
        //pop,poll both start from starting value
//        System.out.println("pop " + deque.pop());
//        System.out.println("poll" + deque.poll());
//        System.out.println("pollLast " + deque.pollLast());
//        System.out.println("pollFirst" + deque.pollFirst());

        //simialar to peek but throws exception if deque is empty
        System.out.println(deque.element());

    }
    public static void mapMulti(){
        Deque<String> deque = new ArrayDeque<>();
        deque.add("Hello");
        Consumer<String> consumer = String::toCharArray;

        BiConsumer<String,Consumer<String>> biConsumer = (s,consumer1)-> consumer.accept(s);
        deque.stream().mapMulti(biConsumer).forEach(System.out::println);

    }
    public static void toArrayOperations(){
        //Will only take the type <T> for the toArray <T>
        //Use map for other conversions
        Deque<String> deque = getSampleDeque();
        IntFunction<String[]> function = String[]::new;
        String[] people = deque.toArray(function);
        Arrays.stream(people).forEach(System.out::println);

        //Have to map first to use toArray of person, first map to person
        Person[] people1 = deque.stream().map(Person::new)
                .toArray(Person[]::new);

    }

    public static void main(String[] args) {
        //checkDequeAddMethods();
        //dequeStreamOperations();
        //flatMapAndCustomMapping();
       // filterOperations();
        //offerOperations();
        //toArrayOperations();
        mapMulti();
    }
}
