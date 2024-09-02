package org.sigar.Generics;

import java.util.Arrays;
import java.util.HashMap;

public class GenericsTest {
    public static void main(String[] args) {
        Integer[] intArr = {2,4,5,6,7};
        Character[] charArr = {'a','b','c'};
        Double[] doubleArr = {2.0,4.0,5.0,6.0};
        Float[] floatArr = {2.0f,4.0f,5.0f,6.0f};

        printArr(charArr);
        HashMap<Integer,String> map = new HashMap<>();

    }

    public static <Thing> void printArr(Thing[] arr){
//        for(Thing thing : arr){
//            System.out.println(thing);
//        }
        Arrays.stream(arr).forEach(System.out::println);
        return;
    }

}
