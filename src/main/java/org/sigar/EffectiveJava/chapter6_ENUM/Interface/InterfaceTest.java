package org.sigar.EffectiveJava.chapter6_ENUM.Interface;

public class InterfaceTest {
    public static void main(String[] args) {

        BasicOperation operation = BasicOperation.PLUS;
        System.out.println(operation.apply(34,43));
        BasicOperation.test(BasicOperation.class,34,343);
    }
}
