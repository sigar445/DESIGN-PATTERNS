package org.sigar.Maps;

import java.util.HashMap;
import java.util.Map;

public class MapsIterator {
    public static void main(String[] args) {
        Map<Integer,String> integerStringMap = new HashMap<>();
        integerStringMap.put(23,"sdfsdf");
        integerStringMap.put(243,"qwsdfsdf");
        integerStringMap.put(231,"nhsdfsdf");

        integerStringMap.forEach((k,v)-> System.out.println(k + " " + v));


    }
}
