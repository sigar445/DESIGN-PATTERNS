package org.sigar.examples;

import org.sigar.model.Apple;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Lambda {

    public static void main(String[] args) {
        File[] hiddenFiles = new File("").listFiles(File::isHidden);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        };
        File[] filteredFiles = new File("").listFiles(fileFilter);



        List<String> names = Arrays.asList("tom","kim","lee","abc","dew");
        names.sort(String::compareTo);
        names.forEach(System.out::println);

        List<Apple> apples = filterGreenApples(generateApplesList());
        apples.forEach(apple-> System.out.println(apple.getWeight() + "  " + apple.getColor()));


    }

    public static List<Apple> filterGreenApples(List<Apple> apples){

        List<Apple> result;

//        for(Apple apple : apples){
//            if(apple.getColor().equals("green")){
//                result.add(apple);
//            }
//        }

        result = apples.stream()
                .filter(apple -> apple.getColor().equals("green"))
                .filter(apple -> apple.getWeight() < 12)
                .collect(toList());

        return result;
    }

    public static List<Apple> generateApplesList(){
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("green", 13));
        apples.add(new Apple("blue", 3));
        apples.add(new Apple("red", 3));
        apples.add(new Apple("green", 3));

        apples.add(new Apple("yellow", 15));
        apples.add(new Apple("green", 0.3));

        apples.add(new Apple("green", 1.8));
        return apples;
    }
}
