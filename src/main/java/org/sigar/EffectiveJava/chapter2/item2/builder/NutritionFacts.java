package org.sigar.EffectiveJava.chapter2.item2.builder;

import lombok.Builder;

@Builder
public class NutritionFacts {

    private double calories;
    private double sodium;
    private double protein;
    private int servings;

    @Override
    public String toString(){
       // return "calories: " + calories + " sodium: " + sodium + " protein: " + protein;
        return String.format("calories = %.2f,sodium = %.2f,protein = %.2f,servings = %d",
                calories,sodium,protein,servings);
    }
}
