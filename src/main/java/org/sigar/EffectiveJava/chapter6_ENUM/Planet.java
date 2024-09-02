package org.sigar.EffectiveJava.chapter6_ENUM;

public enum Planet{

    MERCURY(3.45,343),
    VENUS(3.23,4543);
    
    private final double mass;
    private final double radius;

   // private final double radius;
    Planet(double v, int i) {
        this.mass = v;
        this.radius = i;
    }

}
