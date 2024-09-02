package org.sigar.EffectiveJava.chapter5_Generics.stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackObject<E> {

    Object[] elements;
    public final int DEFAULT_SIZE = 2;
    private int size = 0;

    public StackObject() {
        elements = new Object[DEFAULT_SIZE];
    }

    public void ensureCapacity(){
        if(size == elements.length){
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }

    public E pop(){
        if (size == 0)
            throw new EmptyStackException();
        size = size-1;
        @SuppressWarnings("unchecked")
        E element = (E) elements[size];
        elements[size] = null;
        return element;
    }
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    };
}
