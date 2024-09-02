package org.sigar.EffectiveJava.chapter5_Generics.stacks;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack =  new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
