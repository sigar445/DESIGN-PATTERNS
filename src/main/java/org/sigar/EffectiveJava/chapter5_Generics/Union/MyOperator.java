package org.sigar.EffectiveJava.chapter5_Generics.Union;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MyOperator<T> implements UnaryOperator<T> {


    @Override
    @SuppressWarnings("unchecked")
    public T apply(T o) {
        return (T) o.toString();
    }
}
