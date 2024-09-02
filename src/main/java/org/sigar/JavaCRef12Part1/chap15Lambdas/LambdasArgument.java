package org.sigar.JavaCRef12Part1.chap15Lambdas;

import org.springframework.cglib.core.internal.Function;

 class LambdasArgument<T,V> {
     V  run(Function<T, V> f, T value){
         return f.apply(value);
    }
}
