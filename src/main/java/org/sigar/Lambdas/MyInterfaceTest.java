package org.sigar.Lambdas;

public class MyInterfaceTest {

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hello World");
            }
        };

        myInterface.sayHello();
    }
}
