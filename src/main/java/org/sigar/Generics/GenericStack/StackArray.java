package org.sigar.Generics.GenericStack;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StackArray<E> implements Stack<E>{
    int pos;
    E[] stack;


    @SuppressWarnings("unchecked")
   public StackArray(int size){
        pos = 0;
        stack  = (E[]) new Object[size];
    }


    @Override
    public void push(E element) {
        if(pos >= stack.length){
            System.out.println("Stack is full, increase size or pop elements to push");
            return;
        };
        stack[pos++] = element;
    }

    @Override
    public E pop() {
        return pos > 0 ? stack[--pos]:null;
    }
}
