package org.sigar.EffectiveJava.chapter4;

import java.util.HashSet;
import java.util.List;

public class InstrumentTest {
    public static void main(String[] args) {

        Instrument <String> s = new Instrument<String>(new HashSet<>());

        s.addAll(List.of("Snap", "Crackle", "Pop"));
        //s.addAll(List.of("Snap", "Crackle", "Pop"));

        System.out.println(s.getCounter());

    }
}
