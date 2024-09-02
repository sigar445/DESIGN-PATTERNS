package org.sigar.JavaCRef12Part1.chap6Classes;
class CommandLine {
    public static void main(String[] args) {
        for(int i=0; i<args.length; i++)
            System.out.println("args[" + i + "]: " +
                    args[i]);
    }
}
