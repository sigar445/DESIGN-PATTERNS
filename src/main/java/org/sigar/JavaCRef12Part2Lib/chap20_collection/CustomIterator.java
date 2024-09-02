package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomIterator<T> implements Iterator<T> {
    T[] array;
    int position;

    CustomIterator(T[] newArray){
        array = newArray;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < array.length;
    }

    @Override
    public T next() {
        if(!hasNext()) throw new NoSuchElementException("List is empty");
        return array[position++];
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action);
    }
}
