package org.sigar.JavaCRef12Part2Lib.chap20_collection;

public class CustomLinkedListDemo {

    public static void main(String[] args) {
        checkSize3List();
    }

    public static void checkSize3List(){
        Integer[] vals = {34,343,54};
        CustomLinkedList<Integer> list = new CustomLinkedList<>(vals);
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        list.removeLast();

    }
}
