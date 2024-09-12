package org.sigar.Wildcards;

import org.sigar.Generics.GenericStack.DequeStack;
import org.sigar.Generics.GenericStack.Stack;

import java.util.Collection;
import java.util.List;

public class WildClassTest <E>{

    public static void main(String[] args) {

    }
    void  swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
      //  swapHelper(l1,l2);
    }


    public static <T extends Number> void swapHelper(List<T> l1, List<T> l2) {
        // Temporary variable to hold the first element of the first list
        T temp = l1.get(0);

        // Swapping the first elements of both lists
        l1.set(0, l2.get(0));
        l2.set(0, temp);
    }
//    public static <T extends Number> void swapHelper(List<T> l1, List<T> l2) {
//        T temp = l1.get(0);
//        l1.set(0, l2.get(0));
//        l2.set(0, temp);
//    }
   // public void addStacks(Collection<? extends Stack<E>> collection)// add stack won't work

    public void addStacks(Collection<? super Stack<E>> collection){
        collection.forEach(System.out::println);
        collection.add(new DequeStack<>());
    }
}
