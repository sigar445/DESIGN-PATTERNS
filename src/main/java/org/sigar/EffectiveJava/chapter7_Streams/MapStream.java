package org.sigar.EffectiveJava.chapter7_Streams;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MapStream {


    public static void main(String[] args){

        String[] val = {"SFsdf","sited","SFsf","ewrwer","werd","qas","wer","qas"};

        Map<String,Integer> integerMap = new TreeMap<>();
        for(String s : val) {
            integerMap.merge(s, 1, Integer::sum);
        }
        //integerMap.forEach(System.out::println);
        System.out.println(integerMap);
    }

}
