package org.sigar.JavaCRef12Part2Lib.chap21_java_util;

import java.util.Formatter;

public class FormatterDemo {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        fmt.format("Hello %s , %f mt %d","Tony" ,34f,45);
        System.out.println(fmt);
        fmt.format("Hex: %x, Octal: %o", 196, 196);
        System.out.println(fmt);
    }
}
