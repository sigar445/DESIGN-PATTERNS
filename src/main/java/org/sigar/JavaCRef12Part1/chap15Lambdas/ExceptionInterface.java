package org.sigar.JavaCRef12Part1.chap15Lambdas;

public interface ExceptionInterface<T>{

    public void func(T[] val) throws EmptyArrayException;
}
