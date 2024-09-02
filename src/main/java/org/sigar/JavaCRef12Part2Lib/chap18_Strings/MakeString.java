package org.sigar.JavaCRef12Part2Lib.chap18_Strings;

public class MakeString {


    public static void main(String[] args) {
        char[] java = {'j','a','v','a'};
        String s1 = new String(java);
        String s2 = new String(s1);
        System.out.println(s1 + " " + s2);
        s2 = s1 + 2 + 2;
        System.out.println(s2);

        byte[] bytes = {65,66,67,68,69,70};

        String s3 = new String(bytes);
        System.out.println(s3);
        s3 = new String(bytes,2,1);
        System.out.println(s3);
        fromStringBuilder();
        fromStringBuffer();


    }

    public static void fromStringBuilder(){
        //Faster then stringbuffer, used in single thread scenario
        StringBuilder sb = new StringBuilder();
        sb.append(343);
        sb.append("rer");
        sb.append('c');
        String s = new String(sb);
        System.out.println(s);
        System.out.println(sb.toString());
    }
    static private void fromStringBuffer(){
        // Use in a mutithreaded environment
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(343);
        System.out.println(stringBuffer.toString());

    }
}
