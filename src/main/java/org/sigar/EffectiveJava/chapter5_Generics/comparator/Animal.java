package org.sigar.EffectiveJava.chapter5_Generics.comparator;


class Animal implements Comparable<Animal> {
    @Override
    public int compareTo(Animal other) {
     //   other.compareTo(this);
        return 0;
    }
}

