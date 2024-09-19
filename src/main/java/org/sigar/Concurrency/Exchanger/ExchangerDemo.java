package org.sigar.Concurrency.Exchanger;

import java.util.concurrent.Exchanger;

import static java.lang.Thread.sleep;

public class ExchangerDemo {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        FillString fillString = new FillString(exchanger);
        MakeString makeString = new MakeString(exchanger);

        new Thread(fillString,"Filler").start();
        new Thread(makeString,"Maker").start();
        sleep(1000);
        System.out.println(makeString.getStr());

    }
}
