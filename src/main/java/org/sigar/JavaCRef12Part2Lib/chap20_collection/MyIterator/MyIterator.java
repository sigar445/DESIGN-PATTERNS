package org.sigar.JavaCRef12Part2Lib.chap20_collection.MyIterator;

import java.util.*;
import java.util.function.Consumer;

public class MyIterator<T> implements Iterable<T>{
    private Node<T> first,last;
    private int size;
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    private static class Node<T>{
        public Node<T> next;
        public Node<T> prev;
        T val;
         Node(T val){
             this.val = val;
             next = null;
         }
    }
    Node<T> node(int index) {
        // assert isElementIndex(index);
        if(index >= size) return  null;
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
//    private class NodeIterator implements ListIterator<T>{
//        private Node<T> lastReturned,next;
//        private int nextIndex;
//        NodeIterator(int ind){
//            next = node(ind);
//            nextIndex = ind;
//        }
//        @Override
//        public void forEachRemaining(Consumer<? super T> action) {
////            ListIterator.super.forEachRemaining(action);
//            Objects.requireNonNull(action);
//            while(nextIndex < size){
//                action.accept(next.val);
//                lastReturned = next;
//                next = next.next;
//                nextIndex++;
//            }
//        }
//
//        @Override
//        public boolean hasNext() {
//            return nextIndex < size;
//        }
//
//        @Override
//        public T next() {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            lastReturned = next;
//            next = next.next;
//            nextIndex++;
//            return lastReturned.val;
//        }
//
//        @Override
//        public boolean hasPrevious() {
//            return nextIndex>0;
//        }
//
//        @Override
//        public T previous() {
//            if (!hasPrevious())
//                throw new NoSuchElementException();
////            next = lastReturned;
////            lastReturned = lastReturned.prev;
//            lastReturned = next = (next == null) ? last : next.prev; //Study this why
//            nextIndex--;
//            return next.val;
//        }
//
//        @Override
//        public int nextIndex() {
//            return nextIndex;
//        }
//
//        @Override
//        public int previousIndex() {
//            return nextIndex-1;
//        }
//
//        @Override
//        public void remove() {
//            if (lastReturned == null)
//                throw new IllegalStateException();
//            Node<T> lastNext = lastReturned.next;
//            unlink(lastReturned);
//            if (next == lastReturned)
//                next = lastNext;
//            else
//                nextIndex--;
//            lastReturned = null;
//
//        }
//
//        @Override
//        public void set(T t) {
//            if (lastReturned == null)
//                throw new IllegalStateException();
//            lastReturned.val = t;
//        }
//
//        @Override
//        public void add(T t) {
//            lastReturned = null;
//            if (next == null)
//                linkLast(e);
//            else
//                linkBefore(e, next);
//            nextIndex++;
//        }
//    }
//
//    T unlink(Node<T> x) {
//        // assert x != null;
//        final T element = x.val;
//        final Node<T> next = x.next;
//        final Node<T> prev = x.prev;
//
//        if (prev == null) {
//            first = next;
//        } else {
//            prev.next = next;
//            x.prev = null;
//        }
//
//        if (next == null) {
//            last = prev;
//        } else {
//            next.prev = prev;
//            x.next = null;
//        }
//
//        x.val = null;
//        size--;
//        return element;
//    }


}
