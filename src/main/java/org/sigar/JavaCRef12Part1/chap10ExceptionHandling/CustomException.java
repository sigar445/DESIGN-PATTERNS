package org.sigar.JavaCRef12Part1.chap10ExceptionHandling;

public class CustomException extends Exception{
    private final int detail;


    public CustomException(int detail) {
        this.detail = detail;
    }
    @Override
    public String toString(){
        return "Exception [ " + detail + " ]";
    }

}
