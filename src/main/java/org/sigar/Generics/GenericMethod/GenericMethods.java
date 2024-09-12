package org.sigar.Generics.GenericMethod;

import org.sigar.Generics.GenericStack.Stack;
import org.sigar.Generics.GenericStack.StackArray;
import org.sigar.JavaCRef12Part2Lib.chap20_collection.MyDeque.Person;

import java.util.Comparator;

public class GenericMethods<T> {

    @SuppressWarnings("Unchecked")
    public static <T> Stack<T> loadFromArray(Object[] objects, Class<T> type){
        Stack<T> stack = new StackArray<>(2);
        for(Object o : objects){
            if(type.isInstance(o)) stack.push((T) o);
        }
        return stack;
    }

    public static void main(String[] args) {
        Object[] objects = new Object[5];
        objects[0]  = new StackArray<String>(3);
        objects[1] = 34;
        objects[2] = new Person(34);
        objects[3]  = new StackArray<String>(3);
        objects[4]  = new StackArray<String>(3);

        Stack<Integer> stack = loadFromArray(objects,Integer.class);
        System.out.println(stack.toString());
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(1, "pear");
        boolean same = GenericMethods.<Integer,String>compare(p1, p2);
        System.out.println(same);


    }
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}
