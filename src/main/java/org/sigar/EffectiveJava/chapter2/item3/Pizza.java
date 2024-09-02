package org.sigar.EffectiveJava.chapter2.item3;

import java.util.EnumSet;
import java.util.Set;

public abstract class Pizza {
    public enum TOPPING {HAM, ONION, PEPPER, CAPSICUM, MUSHROOM,CHEESE}

    final Set<TOPPING> toppings;

    public abstract static class Builder<T extends Builder<T>> {

        private final Set<TOPPING> toppings = EnumSet.noneOf(TOPPING.class);

        public T addTopping(TOPPING topping){
            toppings.add(topping);
            return self();
        }
        abstract Pizza build();
        abstract T self();
        protected Set<TOPPING> getToppings() {
            return EnumSet.copyOf(toppings);
        }
    }

    Pizza(Builder<?> b){toppings = b.getToppings();}

    @Override
    public String toString() {
        return " with toppings " + toppings.toString();
    }

}















    //    abstract static class Builder<T extends Builder<T>> {
//        EnumSet<TOPPING> toppings;
//
//        public T topping(TOPPING topping) {
//            toppings.add(topping);
//            //toppings.add(Objects.requireNonNull(topping));
//            return self();
//        }
//        abstract Pizza build();
//        public abstract T self();
//    }
//    Pizza(Builder<?> builder){toppings = EnumSet.copyOf(builder.toppings);}
//       // EnumSet<TOPPING> toppings = EnumSet.empty();
//}
