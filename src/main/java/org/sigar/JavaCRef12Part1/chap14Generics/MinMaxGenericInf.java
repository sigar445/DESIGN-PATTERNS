package org.sigar.JavaCRef12Part1.chap14Generics;

public interface MinMaxGenericInf<T extends Number>{
    public T max();
    public T min();
}
