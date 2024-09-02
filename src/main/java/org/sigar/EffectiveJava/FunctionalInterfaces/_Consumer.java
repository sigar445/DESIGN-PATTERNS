package org.sigar.EffectiveJava.FunctionalInterfaces;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.FEMALE;
import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.MALE;

public class _Consumer {

    public static void main(String[] args){
        BiPredicate<Person, Integer> aboveAgePredicate = ((person,age) -> person.getAge() > age);

        BiConsumer<List<Person>,Integer> aboveAge = ((people,age) ->
                people.stream().filter((person) -> aboveAgePredicate.test(person,age))
                .toList()
                .forEach(System.out::println)
        );

        BiPredicate<Person, Person.Gender> genderPredicate = ((person,gender) -> gender.equals(person.getGender()));
        Person.Gender genderFilter = MALE;
        Integer minAge = 40;
        Consumer<List<Person>> filterByGender = (people->
                people.stream()
                .filter(person -> genderPredicate.test(person,genderFilter) && aboveAgePredicate.test(person,minAge))
                .toList()
                .forEach(System.out::println)
        );
        List<Person> people = Constants.personList;
        filterByGender.accept(people);

    }
}
