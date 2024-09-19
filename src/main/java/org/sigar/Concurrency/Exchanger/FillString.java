package org.sigar.Concurrency.Exchanger;

import lombok.AllArgsConstructor;

import java.util.concurrent.Exchanger;

@AllArgsConstructor
public class FillString implements Runnable {

    Exchanger<String> exchanger;

    @Override
    public void run() {
        for(int index = 0;index<5;index++){
            try {
                String s = Thread.currentThread().getName() + (int) (Math.random() * 100);
                exchanger.exchange(s);
            }catch (InterruptedException e){
                System.out.println("Caught Interrupted Exception " + e.fillInStackTrace());
            }
        }
    }
}
