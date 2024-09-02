package org.sigar.EffectiveJava.chapter5_Generics.stacks;

import java.util.ArrayList;
import java.util.List;

public class StackGeneric<T> {

    List<T> stack;
    T[] element;
    static final int DEFAULT_SIZE  = 16;
    private int size = 0;

    @SuppressWarnings("unchecked")
    StackGeneric() {
        stack = new ArrayList<>(DEFAULT_SIZE);
        element = (T[]) new Object [DEFAULT_SIZE];
    }

    public void push(T element) {
       // ensureCapacity();
        stack.add(size,element);
        size += 1;
    }

    public T pop() {
        size = size - 1;
        T element = stack.remove(size);
        stack.add(size,null);
        return element;
    }

}
