package org.sigar.Lists.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class LinkedListBasics {
    public static void basicList(){

        String s = "Hello How are you take care";
        List<String> list = Arrays.stream(s.split(" ")).toList();
        List<String> linkedList =  new LinkedList<>(list);
        BiConsumer<String,Consumer<Character>> stringConsumer = (val,consumer)->{
            char[] chars = val.toCharArray();
            for(Character c : chars) consumer.accept(c);
        };
        // consumers characters by words
        BiConsumer<String,Consumer<char[]>> wordConsumer = (val, consumer)->{
            consumer.accept(val.toCharArray());
        };
        List<Character []> wordList =  linkedList
                .stream()
                .mapMulti(wordConsumer)
                .map(chars -> IntStream.range(0,chars.length)
                        .mapToObj(c -> chars[c]) // Convert char to Character using valueOf
                        .toArray(Character[]::new))
                .toList();

        wordList.forEach(word -> System.out.println(Arrays.toString(word)));
       // stringConsumer.accept("sdfs  dfsdf");
//        linkedList.stream().mapMulti((str,consumer) ->{
//
//            consumer.accept(str.toCharArray());
//        }).forEach(System.out::println);


    }

    public static void main(String[] args) {
        basicList();
    }
}
