package org.sigar.JavaCRef12Part1.chap5Loops;

public class _DoWhile {
    public static void main(String[] args) {

        int first = 4,second = 4;

        while (first>0){
            System.out.println(first);
            first--;
        }

        do{
            System.out.println(second);
            second--;
        }while (second > 0);


        //do while always execute a loop once, even if condition is false
        do{
            System.out.println(second);
            second--;
        }while (second > 0);

}
}
