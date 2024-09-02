package org.sigar.EffectiveJava.chapter5_Generics.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {

    private E[] elements;
    private int size = 0;
    public static int DEFAULT_SIZE = 18;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_SIZE];
    }
    public void ensureCapacity(){
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size*2 + 1 );
        }
    }
    public void push(E e) {
        ensureCapacity();
        elements[size] = e;
        size++;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size = size-1;
        E e = elements[size];
        elements[size] = null;
        return e;
    }
}
