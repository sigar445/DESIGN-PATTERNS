package org.sigar.JavaCRef12Part1.chap16SwitchRecord;

public class RecordDemo {

    public static void main(String[] args) {
        Employee john = new Employee("john",50);

        System.out.println(john);

        System.out.println("Is john old " + john.isOld());
    }
}
