package org.sigar.JavaCRef12Part2Lib.chap18_Strings;

public class EqualsDemo {
    public static void main(String[] args) {

        String s1 = "qwerty";
        String s2 = "qwerty";
        String s3 = new String(s1);
        //The Java String pool is a special memory area where String literals (strings enclosed in double quotes) are stored.
        // When you create a String literal, the JVM checks if the string already exists in the pool.
        // If it does, it returns a reference to the existing string. If not,
        // it creates a new String object and adds it to the pool.
        System.out.println("==  " + (s1 == s3));

        System.out.println("Equals " + s1.equals(s3));
  //      regionMatches();
//        startAndEndsWith();
    }
    static void regionMatches(){

        String s1 = "That is demo of region matches method";
        String s2 = "ThAT is demo of getChars method";

        boolean result = s1.regionMatches(1,s2,1,4);

        System.out.println(result);
        result  = s1.regionMatches(true,1,s2 ,1,4);
        System.out.println(result);
    }
    static void startAndEndsWith(){
        String s1 = "That is demo of region matches method";
        boolean result = s1.startsWith("Thit");
        System.out.println(result);
        result = s1.startsWith("is",6);
        System.out.println(result);

        result = s1.endsWith("thod");

        System.out.println(result);

    }
}
