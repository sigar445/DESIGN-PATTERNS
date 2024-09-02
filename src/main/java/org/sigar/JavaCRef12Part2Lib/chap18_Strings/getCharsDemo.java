package org.sigar.JavaCRef12Part2Lib.chap18_Strings;

public class getCharsDemo {
    public static void main(String[] args) {
        String s = "This is demo of getChars method";
        int start = 5,end = 12;
        char[] buf = new char[end-start];
        s.getChars(start,end,buf,0);
        System.out.println(buf);
        byte[] bytes = new byte[end-start];
        //Bytes contain numeric values representing the characters
        s.getBytes(start, end, bytes, 0);
        for (byte b:bytes) System.out.println(b);
        System.out.println(new String(bytes));

        char[] charArr = s.toCharArray();
        System.out.println(charArr);
    }
}
