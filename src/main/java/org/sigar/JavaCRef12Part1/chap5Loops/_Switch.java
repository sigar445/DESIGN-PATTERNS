package org.sigar.JavaCRef12Part1.chap5Loops;

public class _Switch {
    public static void main(String[] args) {


        for(int ind=0; ind<12; ind++){

            switch (ind){
                case 0:
                case 1:
                case 2: break;
                case 3:
                case 4:
                default:
                    System.out.println("Ind is greater than 4 " + ind);

            }
        }
    }
}
