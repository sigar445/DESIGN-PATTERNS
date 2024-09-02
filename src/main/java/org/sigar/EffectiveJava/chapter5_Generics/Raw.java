package org.sigar.EffectiveJava.chapter5_Generics;

import java.util.*;
public class Raw {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        unsafeAdd(list,Integer.valueOf(0));
        String s = (String)list.get(0);
    }
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
