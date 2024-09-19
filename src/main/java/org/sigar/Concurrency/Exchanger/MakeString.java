package org.sigar.Concurrency.Exchanger;

import lombok.Getter;

import java.util.concurrent.Exchanger;

@Getter
public class MakeString implements Runnable{
   Exchanger<String> exchanger;
    String str;
    public MakeString(Exchanger<String> exchanger){
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        try{
            for(int index = 0; index < 5;index++ ){
                str = exchanger.exchange(new String());
                System.out.println("Got: " + str);
            }
        }catch (InterruptedException e){
            System.out.println("Caught " + e.fillInStackTrace());
        }
    }
}
