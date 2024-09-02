package org.sigar.EffectiveJava.chapter5_Generics;

import java.util.HashSet;
import java.util.Set;

public class Stamps<T> {

    private final Set<T> stampsCollection;
    public Stamps(Set<T>  stampsCollection) {
        this.stampsCollection = stampsCollection;
    }

    public Set<T> getStampsCollection() {
        return stampsCollection;
    }

    public void addStamp(T stamp){
        stampsCollection.add(stamp);
    }
}
