package org.sigar.JavaCRef12Part2Lib.chap20_collection;

public class IteratorDemo {
    public static void main(String[] args) {

        String[] vals = {"first","second","third","fourth"};
        CustomIterator<String> it = new CustomIterator<>(vals);
       // it.forEachRemaining(System.out::println);

        while(it.hasNext()){
            System.out.println(it.next());
            //it.next();
        }
    }
}
