package org.sigar.EffectiveJava.chapter5_Generics.stacks;

public class StackObjectTest {
    public static void main(String[] args) {
        StackObject<Integer> stackObject = new StackObject<>();
        stackObject.push(1);
        stackObject.push(2);
        stackObject.push(39);
        stackObject.push(539);

        stackObject.push(3349);
        System.out.println(stackObject.pop());

        System.out.println(stackObject.pop());
        System.out.println(stackObject.pop());
        System.out.println(stackObject.pop());
    }
}
