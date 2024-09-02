package org.sigar.EffectiveJava.FunctionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

import static org.sigar.EffectiveJava.FunctionalInterfaces.Constants.personList;
import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.FEMALE;
import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.MALE;

public class PredicateUse {

    public static void main(String[] args) {

        Predicate<Person> predicate = person -> FEMALE.equals(person.getGender());
        personList.stream()
                .filter(predicate)
                .toList()
                .forEach(System.out::println);

        System.out.println();

        Predicate<Person> ageLessThen50 = person -> person.getAge()<50;
        Predicate<Person> femaleLessThan50 = predicate.and(ageLessThen50);


        personList.stream().filter(femaleLessThan50).forEach(System.out::println);
        Person ram = new Person("ram",MALE,43);
        System.out.println("If ram younger than 50 " + ageLessThen50.test(ram));

    }
}
