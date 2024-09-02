package org.sigar.EffectiveJava.chapter5_Generics;

import java.util.HashSet;
import java.util.*;
public class StampsTest {

    public static void main(String[] args) {

        Stamps<Coins> stamps = new Stamps<Coins>(new HashSet<Coins>());
        List<String> stringList = new ArrayList<>();
        Class<?> listClass = List.class;
        System.out.println(listClass.getName());
        Class<?> clazz = stringList.getClass(); // This is legal and will give you ArrayList.class
        List<?> list = new ArrayList<>();
        System.out.println(list.getClass());
       // list.add("4");


    }
}
