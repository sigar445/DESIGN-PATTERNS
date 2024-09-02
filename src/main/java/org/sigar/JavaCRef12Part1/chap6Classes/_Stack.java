package org.sigar.JavaCRef12Part1.chap6Classes;

import java.util.Objects;

public class _Stack<T> {

    private final Object[] stck;
    private int pos;

    public _Stack(int size) {
        stck = new Object[size];
        pos = 0;
    }

    public boolean isFull(){
        return pos==stck.length;
    }
    public boolean isEmpty(){
        return pos==0;
    }
    public void add(T item){
        if(isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stck[pos++] = Objects.requireNonNull(item,"Item cannot be null");
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return (T) stck[pos];
    }
    @SuppressWarnings("unchecked")
    public T poll(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        T item =  (T) stck[pos];
        stck[pos--] = null;
        return item;
    }

    public static void main(String[] args) {
        _Stack<String> stack = new _Stack<>(4);
        stack.add("Ehsf");
        stack.add("Ehsf");
        stack.add("Ehsf");
        stack.add(null);

        System.out.println(stack.poll());

    }
}
