package org.sigar.EffectiveJava.chapter2.item3;

import static org.sigar.EffectiveJava.chapter2.item3.Cheeseburst.CHEESE.GOAT;
import static org.sigar.EffectiveJava.chapter2.item3.VeggiePizza.SIZE.MEDIUM;

public class PizzaTest {
    public static void main(String[] args) {

//        VeggiePizza veggiePizza = (VeggiePizza) new VeggiePizza.VPBuilder(MEDIUM)
//                .addTopping(Pizza.TOPPING.MUSHROOM)
//                .addTopping(Pizza.TOPPING.CAPSICUM)
//                .build();
//
//        System.out.println(veggiePizza);

        Cheeseburst cheeseburst = new Cheeseburst.CBBuilder(GOAT)
                .addTopping(Pizza.TOPPING.HAM)
                .addTopping(Pizza.TOPPING.MUSHROOM)
                .build();
        System.out.println(cheeseburst);


    }
}
