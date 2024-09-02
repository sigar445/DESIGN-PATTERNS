package org.sigar.EffectiveJava.chapter4;

import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Getter
//public class Instrument<E> extends HashSet<E> {
public class Instrument<E> extends ForwardingSet<E> {

    private int counter = 0;
//
//    Instrument(int cap,float loadFactor){
//        super(cap,loadFactor);
//    }
    Instrument(Set<E> set){
        super(set);
    }
    @Override
    public boolean add(E e) {
        counter++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        counter+=c.size();
        return super.addAll(c);
    }

}
