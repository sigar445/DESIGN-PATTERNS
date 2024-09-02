package org.sigar.JavaCRef12Part1.chap9Interfaces;

public class CallbackTest {

    public static void main(String[] args) {

        Callback cb = new Client();
        Callback anotherClient = new AnotherClient();
        cb.callback(343);

        cb = anotherClient;
        cb.callback(342);

        Client client = new Client();
        client.test();

        Callback cbm = System.out::println;
        cbm.callback(34);
        cbm.defaultMethod();
        Callback sef = new ExtendCallback() {
            @Override
            public void extend() {

            }

            @Override
            public void callback(int param) {

            }
        };
        System.out.println(StaticMethod.sayHello());
    }
}
