package org.sigar.JavaCRef12Part2Lib.chap21_java_util;

import java.util.StringTokenizer;

public class Tokenizer {

    static String in = " Title = Java 12 Ref; " + " author = Schildt; " + " publisher = McGraw Hill; " +
            " copyright = 2022 ";

    public static void main(String[] args) {

            StringTokenizer st = new StringTokenizer(in,"=;");

            while(st.hasMoreTokens()){
                String key = st.nextToken();
                String val = st.nextToken();
                System.out.println(key + "\t" + val);
            }

            String vehileString = "car,truck;plane.rail";
            StringTokenizer token = new StringTokenizer(vehileString,",;.");
            while(token.hasMoreTokens()){
                System.out.println(token.nextToken());
            }

    }
}
