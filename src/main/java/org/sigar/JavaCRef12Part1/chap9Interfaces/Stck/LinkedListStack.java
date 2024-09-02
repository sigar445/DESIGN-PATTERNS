package org.sigar.JavaCRef12Part1.chap9Interfaces.Stck;

import java.util.LinkedList;

public class LinkedListStack<T> implements VarStack<T> {

    private final LinkedList<T> linkedList;
    private int pos;
    public LinkedListStack (){
        linkedList = new LinkedList<>();
        pos = -1;
    }

    public void push(T obj){
        pos++;
        linkedList.addLast(obj);
    }
    public T pop(){
        T top = linkedList.get(pos);
        System.out.println("Popping the element at " + pos);
        linkedList.set(pos,null);
        pos--;
        return top;
    }
}