package org.sigar.JavaCRef12Part2Lib.chap18_Strings;

public class IndexOfDemo {
    public static void main(String[] args) {
        subStringFinder();
        String s = "Now is the time for all good men " +
                "to come to the aid of their country.";
        System.out.println(s);
        System.out.println("indexOf(t) = " +
                s.indexOf('t'));
        System.out.println("lastIndexOf(t) = " +
                s.lastIndexOf('t'));
        System.out.println("indexOf(the) = " +
                s.indexOf("the"));
        System.out.println("lastIndexOf(the) = " +
                s.lastIndexOf("the"));
        System.out.println("indexOf(t, 10) = " +
                s.indexOf('t', 10));
        System.out.println("lastIndexOf(t, 60) = " +
                s.lastIndexOf('t', 60));
        System.out.println("indexOf(the, 10) = " +
                s.indexOf("the", 10));
        System.out.println("lastIndexOf(the, 60) = " +
                s.lastIndexOf("the", 60));
    }

    static void subStringFinder(){
        String s = "sdfsdf sfsdfwe sdf r3 fewrwdfsdf";
        System.out.println(s.substring(3));
        System.out.println(s.substring(3,6));
    }

}
