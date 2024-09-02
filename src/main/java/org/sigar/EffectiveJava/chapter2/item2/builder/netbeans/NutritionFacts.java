package org.sigar.EffectiveJava.chapter2.item2.builder.netbeans;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class NutritionFacts {

    private final double calories;
    private final double servings;
    private final double proteins;
    private final double sodium;

    public NutritionFacts(NutritionFactsBuilder nutritionFactsBuilder){
        calories = nutritionFactsBuilder.calories;
        servings = nutritionFactsBuilder.servings;
        proteins = nutritionFactsBuilder.proteins;
        sodium = nutritionFactsBuilder.sodium;

    }


    public static class NutritionFactsBuilder{

        private double calories;
        private double servings;
        private double proteins;
        private double sodium;

        public NutritionFactsBuilder calories(double calories){
            this.calories = calories;
            return this;
        }

        public NutritionFactsBuilder servings(double servings){
            this.servings = servings;
            return this;
        }

        public NutritionFactsBuilder proteins(double proteins){
            this.proteins = proteins;
            return this;
        }

        public NutritionFactsBuilder sodium(double sodium){
            this.sodium = sodium;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    public static void main(String[] args) {

       NutritionFacts nutritionFacts = new NutritionFactsBuilder()
                .servings(3)
                .calories(4.5)
                .proteins(2.3)
                .sodium(4.1)
                .build();

        System.out.println(nutritionFacts);

    }

    @Override
    public String toString(){
        // return "calories: " + calories + " sodium: " + sodium + " protein: " + protein;
        return String.format("calories = %.2f,sodium = %.2f,protein = %.2f,servings = %f",
                calories,sodium,proteins,servings);
    }
}
