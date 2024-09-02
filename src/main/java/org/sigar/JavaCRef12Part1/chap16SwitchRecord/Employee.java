package org.sigar.JavaCRef12Part1.chap16SwitchRecord;

public record Employee(String name,int age) {

    public boolean isOld(){
        return age > 60;
    }
}
