package org.sigar.EffectiveJava.chapter2.item3;

public class Cheeseburst extends Pizza{

    public enum CHEESE {CHEDDAR, GOAT, NORMAL}
    private final CHEESE cheese;

    private Cheeseburst(CBBuilder cbBuilder){
        super(cbBuilder);
        cheese = cbBuilder.cheese;
    }
    public static class CBBuilder extends Builder<CBBuilder>{

        private final CHEESE cheese;
        public CBBuilder(CHEESE cheese){
            this.cheese = cheese;
        }
        public CHEESE getCheese() {return cheese;}

        @Override CBBuilder self() {return this;}
        @Override Cheeseburst build(){return new Cheeseburst(this);}
    }
    @Override
    public String toString(){
        return "Cheeseburst with " + cheese + " cheese" + super.toString();
    }


}
