package org.sigar.JavaCRef12Part2Lib.chap18_Strings;

public class ReplaceStr {

    public static void main(String[] args) {
        String s = "This is a cat, This is a horse";
        String search = "This",subs = "That";
        replaceStr(s,search,subs);

        //With new string methods
        String subString = s.replace(search,subs);
        System.out.println(subString);
    }
    static void replaceStr(String s,String search,String subs){
        int i = -1;
        StringBuilder sb = new StringBuilder(s);
        while(true) {
            i = sb.indexOf(search,i);
            if (i == -1) break;
            sb.replace(i, i + search.length(), subs);
        }
        System.out.println(sb.toString());
    }
}
