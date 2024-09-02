package org.sigar.EffectiveJava.chapter5_Generics.Union;

import java.util.HashSet;
import java.util.Set;

public class Union {

    public <E> Set<E> union(Set<E> set1, Set<E> set2){
        Set<E> unionSet = new HashSet<E>(set1);
        //unionSet.addAll(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public static void main(String[] args) {
        Union unionSet = new Union();
        Set<String> set1  = Set.of("34","sdfs","grtr");
        Set<String> set2  = Set.of("gd34","s54dfs","werwgrtr");
        Set un = unionSet.union(set1,set2);
        System.out.println(un);

    }

}
