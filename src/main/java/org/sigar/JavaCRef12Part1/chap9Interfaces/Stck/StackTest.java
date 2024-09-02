package org.sigar.JavaCRef12Part1.chap9Interfaces.Stck;

public class StackTest {

        public static void main(String[] args) {
            VarStack<String> stack = new LinkedListStack<>();
            stack.push("first");
            stack.push("second");
            stack.push("three");

            System.out.println(stack.pop());

        }

}
