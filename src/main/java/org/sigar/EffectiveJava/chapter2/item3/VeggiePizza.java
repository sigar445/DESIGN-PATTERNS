package org.sigar.EffectiveJava.chapter2.item3;

import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.Set;
public class VeggiePizza extends  Pizza {

    public enum SIZE {SMALL, MEDIUM, LARGE}
    private SIZE size;

    VeggiePizza(VPBuilder builder) {
        super(builder);
        this.size = builder.size;
    }

    public static class VPBuilder extends Pizza.Builder<VPBuilder> {

        private SIZE size;

        public VPBuilder(SIZE size) {
            this.size = size;
            // super();
        }

//        public VPBuilder setSize(SIZE size) {
//            this.size = size;
//            return this;
//        }

        @Override public VeggiePizza build() {return new VeggiePizza(this);}
        @Override public VPBuilder self() {return this;}

//        public Builder(SIZE size) {
//            this.size = size;
//        }
    }
    @Override public String toString() {
        return "New York " + size  + super.toString();
    }

}


























//    public enum Size {LARGE,MEDIUM,SMALL}
//    private Size size;
//
//    VeggiePizza(Builder builder){
//        super(builder);
//        size = builder.size;
//    }
//
//    public static class Builder extends Pizza.Builder<Builder>{
//
//        @Override VeggiePizza build() {return new VeggiePizza(this);}
//        @Override public Builder self() {return this;}
//
//        private  final Size size;
//        public Builder(Size size){
//            this.size = size;
//        }
//    }
//    @Override public String toString() {
//        return "New York Pizza with " + toppings;
//    }



