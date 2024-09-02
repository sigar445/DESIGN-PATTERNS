package org.sigar.JavaCRef12Part1.chap10ExceptionHandling;

public class ChainedException  {
    static void demoproc(){
        NullPointerException nullPointerException = new
                NullPointerException("top player");
        nullPointerException.initCause(new ArithmeticException("root cause"));
        throw nullPointerException;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        }catch (NullPointerException e){
            System.out.println("Caught " + e);
            System.out.println("Init cause" + e.getCause());
        }
    }
}
