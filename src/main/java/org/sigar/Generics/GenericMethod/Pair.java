package org.sigar.Generics.GenericMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pair<K, V> {

    private K key;
    private V value;

//    //    public V getValue() { return value; }
}