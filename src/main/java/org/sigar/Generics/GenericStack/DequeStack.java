package org.sigar.Generics.GenericStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStack<E> implements Stack<E> {
    private final Deque<E> stack = new ArrayDeque<>();
    @Override
    public void push(E element) {
        stack.push(element);
    }

    @Override
    public E pop() {
        return stack.poll();
    }
}
