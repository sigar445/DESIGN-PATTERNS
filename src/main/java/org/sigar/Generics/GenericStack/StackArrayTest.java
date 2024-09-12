package org.sigar.Generics.GenericStack;

public class StackArrayTest {
    public static void main(String[] args) {
        StackArray<String> stackArray = new StackArray<>(5);
        stackArray.push("1df");
        stackArray.push("2df");
        stackArray.push("3df");
        stackArray.push("4df");
        stackArray.push("5df");
        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
        stackArray.push("other Element");
        System.out.println(stackArray.pop());
    }
}
