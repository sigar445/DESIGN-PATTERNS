package org.sigar.EffectiveJava.chapter5_Generics.Union;



public class MyComparable implements Comparable<MyComparable>{
    @Override
    public int compareTo(MyComparable first) {
        return 0;
    }
}
