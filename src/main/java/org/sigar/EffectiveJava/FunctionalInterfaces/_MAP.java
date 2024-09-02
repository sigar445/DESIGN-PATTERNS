package org.sigar.EffectiveJava.FunctionalInterfaces;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class _MAP {

    public static void main(String[] args){

        List<Person> persons = Constants.personList;
        Predicate<Person> above45 = person -> person.getAge() > 45;

        persons.stream()
                //.map(Person::getGender)
                .filter(above45)
                .toList()
                .forEach(System.out::println);
    }
}
