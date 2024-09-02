package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import lombok.Getter;
import java.util.NoSuchElementException;

public class CustomLinkedList<T>{
    private Node start;
    private Node end;
    @Getter
    private int size;

    CustomLinkedList(T[] vals){
        if(vals.length == 0)
            throw new IllegalArgumentException("Vals should not be null");
        this.size = vals.length;
        start   = new Node(vals[0],null,null);
        end = new Node(vals[size-1],null,null);
        Node prevNode = start;
        Node curr;
        for(int ind = 1;ind < size-1;ind++){
            curr = new Node(vals[1],null,null);
            prevNode.next = curr;
            curr.prev  = prevNode;
            prevNode = curr;
        }
        prevNode.next = end;
        end.prev = prevNode;
    }

    public void addLast(T addVal){
        size++;
        final Node last = end;
        end = new Node(addVal,end,null);
        if(last == null)
            start = end;
        else
            last.next = end;
    }
    public void removeLast(){
        if(size==0) throw new NoSuchElementException();
        size--;
        Node last = end;
        Node prevLast = end.prev;
        if(prevLast==null){
            start = null;
        }else{
            end.prev = null;
            prevLast.next = null;
        }
        end = prevLast;
    }
    @Override
    public String toString(){
        Node first = start;
        StringBuilder sb = new StringBuilder();
        while(first != null){
            sb.append(" ").append(first.val);
            first = first.next;
        }
        return sb.toString();
    }















    class Node{
        T val;
        Node prev;
        Node next;
        Node(T val,Node prevNode,Node nextNode){
            this.val = val;
            this.prev = prevNode;
            this.next = nextNode;
        }
    }
}
