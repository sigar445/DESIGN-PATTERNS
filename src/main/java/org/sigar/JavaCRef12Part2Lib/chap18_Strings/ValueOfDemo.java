package org.sigar.JavaCRef12Part2Lib.chap18_Strings;

public class ValueOfDemo {

    public static void main(String[] args) {
        stringJoin();
        int intVal = 34;
        double doubleVal = 43.5d;
        float floatVal = 324.34f;
        long longVal = 3243;
        String s = String.valueOf(doubleVal);
        System.out.println(s);
        System.out.println(String.valueOf(intVal));
        System.out.println(String.valueOf(doubleVal));
        System.out.println(String.valueOf(floatVal));
        System.out.println(String.valueOf(longVal));
    }
    static void stringJoin(){
        String result = String.join(" ", "Alpha", "Beta", "Gamma");
        System.out.println(result);
        result = String.join(", ", "John", "ID#: 569",
                "E-mail: John@HerbSchildt.com");
        System.out.println(result);
    }
}
