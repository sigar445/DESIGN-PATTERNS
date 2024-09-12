package org.sigar.Generics.GenericStack;

public class DequeStackTest {
    public static void main(String[] args) {

        Stack<String> stackArray = new DequeStack<>();
        stackArray.push("1d");
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
