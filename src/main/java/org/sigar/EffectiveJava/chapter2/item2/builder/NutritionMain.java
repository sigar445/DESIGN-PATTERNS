package org.sigar.EffectiveJava.chapter2.item2.builder;

public class NutritionMain {

    public static void main(String[] args) {


        NutritionFacts nutritionFacts = NutritionFacts.builder()
                .servings(3)
                .calories(4.5)
                .protein(2.3)
                .sodium(4.1)
                .build();

        System.out.println(nutritionFacts);

    }
}
