package org.sigar.EffectiveJava.chapter5_Generics.stacks;

public class StackGenericMain {

    public static void main(String[] args) {
        StackGeneric<Integer> stackGeneric = new StackGeneric<>();

        stackGeneric.push(9);
        stackGeneric.push(5);
        stackGeneric.push(4);
        System.out.println(stackGeneric.pop());
        stackGeneric.push(3);
        System.out.println(stackGeneric.pop());
        System.out.println(stackGeneric.pop());
    }
}
