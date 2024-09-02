package org.sigar.JavaCRef12Part2Lib.chap18_Strings;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CharExtraction {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String s = "Hello I am here";
        System.out.println(s.charAt(3));
        char[] buf = new char[6];
        s.getChars(0,5,buf,0);
        System.out.println(buf);

        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));
        System.out.println(bytes);

        System.out.println(s.toCharArray());
    }
}
