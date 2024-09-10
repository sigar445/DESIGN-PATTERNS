package org.sigar.JavaCRef12Part2Lib.chap20_collection.MYCOLLECTION;


import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MyCollection<E> implements Collection<E> {
    private static final int  DEFAULT_CAPACITY = 1000;
    private E[] arr;
    private int size;

    @SuppressWarnings("unchecked")
    public MyCollection(int len){
        arr = (E[]) new Object[len];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
//        boolean result = false;
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(o)) {
//                result = true;
//                break;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return Arrays.stream(arr).limit(size).iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr,size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        // If the array is too small, create a new one
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        System.arraycopy(arr, 0, a, 0, Math.min(size, a.length)); // Efficient copy
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }
    private Object[] grow(int minCapacity) {
        int oldCapacity = arr.length;
        int newCapacity = (oldCapacity > 0) ? oldCapacity * 2 : Math.max(DEFAULT_CAPACITY, minCapacity);
        return arr = Arrays.copyOf(arr, newCapacity);
    }

    @Override
    public boolean add(E e) {
        if(size >= arr.length) {
            grow(size+1);
        }
        arr[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
       // assert !c.isEmpty();
        Objects.requireNonNull(c, "Collection cannot be null");
        boolean result = true;
        for(Object element : c){
            if(!contains(element)){
                result = false;
                break;
            }
        }
        return result;

    }

    @Override
    public boolean addAll(Collection<? extends
        E> c) {
        boolean modified = false;
        for (E element : c) {
            modified |= add(element); // Use bitwise OR for efficiency
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
//        for (int ind = 0; ind < size; ind++) {
//            arr[ind]  = null;
//        }
        Arrays.fill(arr, null); // Use fill for efficiency
        size = 0;
    }
    @Override
    public Spliterator<E> spliterator() {
        // Use the internal list's spliterator which supports parallel processing
        return Spliterators.spliterator(arr,0,size,Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED);
    }

    public Stream<E> stream(){
        return StreamSupport.stream(spliterator(),false);
    }
    public Stream<E>  parallelStream(){
        return StreamSupport.stream(spliterator(),true);
    }

}
