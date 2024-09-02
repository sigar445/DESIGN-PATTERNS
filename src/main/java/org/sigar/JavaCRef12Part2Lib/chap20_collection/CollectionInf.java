package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public  class CollectionInf<T> implements Collection<T> {
    T[] values;
    int size;
    @SuppressWarnings("unchecked")
    CollectionInf(int initialCapacity){
        if(initialCapacity<=0)
            throw new IllegalArgumentException("InitialCapacity has to be greater than Zero");
        values = (T []) new Object[initialCapacity];
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;

        for(Object k : values){
            if(k.equals(o)){
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return  new Iterator<>() {
            private int curr = 0;

            @Override
            public boolean hasNext() {
                return curr < size ;
            }

            @Override
            public T next() {
                if (!hasNext()) throw  new NoSuchElementException();
                return values[curr++];
            }
            @Override
            public void remove(){
                if (curr == 0) {
                    throw new IllegalStateException("Cannot remove element before calling next()");
                }
                CollectionInf.this.remove(values[--curr]);
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] copy = new Object[size];
        System.arraycopy(values,0,copy,0,size);
        return copy;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) java.util.Arrays.copyOf(values, size, a.getClass());
        }
        System.arraycopy(values, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T e) {
        if(size == values.length) growCollection();
        values[size++] = e;
        return true;
    }

    @SuppressWarnings("unchecked")
    public void growCollection(){
        T[] newCollection = (T []) new Object[values.length*2];
        System.arraycopy(values,0,newCollection,0,size);
        values = newCollection;
    }


    @Override
    public boolean remove(Object o) {
        boolean result = false;
        for(int ind=0;ind<size;ind++){
            if(values[ind].equals(o)){
                for(;ind<size-1;ind++){
                    values[ind]=values[ind+1];
                }
                values[--size]=null;
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object val : c){
            if(!contains(val)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) {
            add(e);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for(Object val : c){
            remove(val);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for(Object val : values){
            if(!c.contains(val)) {
                remove(val);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }
}
