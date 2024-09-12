package org.sigar.EffectiveJava.FunctionalInterfaces;


import java.util.List;
import java.util.function.BiPredicate;

import static java.lang.Math.abs;
import static org.sigar.EffectiveJava.FunctionalInterfaces.Constants.personList;
import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.MALE;

public class BiPredicateUse {

    public static void main(String[] args) {

        BiPredicate<Person, Person> isCompatible = (person1, person2) -> {
            return !person1.getGender().equals(person2.getGender())
                    && abs(person1.getAge() - person2.getAge()) <= 10
                    && !person1.equals(person2);
        };

        BiPredicate<Integer, Person.Gender> isYoungMale =
                (age, gender) -> age > 18 && gender.equals(MALE);


        personList.stream()
                .flatMap(person1 -> personList.stream()
                        .filter(person2 -> isCompatible.test(person1,person2))
                        .map(person2 -> String.format("%s %s are Compatible",person1.getName(),person2.getName())))
                .forEach(System.out::println);
//
//        List<Person> people = personList;
//        people.stream()
//                .flatMap(person1 -> people.stream()
//                        .filter(person2 -> isCompatible.test(person1, person2))
//                        .map(person2 -> String.format("COMPATIBLE %s %s%n", person1.getFirstName(), person2.getFirstName())))
//                .distinct()
//                .forEach(System.out::print);



//
//        personList.stream()
//                .filter(person->isYoungMale.test(person.getAge(),person.getGender()))
//                .toList()
//                .forEach(System.out::println);



//        Person first = null;
//        Person second = null;
//        for(int ind=0;ind<personList.size();ind++) {
//            first = personList.get(ind);
//            for (int secInd = ind + 1; secInd < personList.size(); secInd++) {
//                second = personList.get(secInd);
//                if (isCompatible.test(first, second)) {
//                    System.out.printf("COMPATIBLE %s %s%n", first.getFirstName(), second.getFirstName());
//                }
//            }
//        }
    }
}
