package org.sigar.EffectiveJava.FunctionalInterfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import static org.sigar.EffectiveJava.FunctionalInterfaces.Constants.personList;
import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.FEMALE;

import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.MALE;

@AllArgsConstructor
@Getter
public class Person {

    static enum Gender {MALE,FEMALE};

    private String name;
    private Gender gender;
    private Integer age;

    @Override
    public String toString() {
        return String.format("firstName = %s,gender = %s,age = %s",name,gender,age);
    }

    public static void main(String[] args) {
        //IMPERATIVE APPROACH
        for(Person person:personList){
            if(person.gender==Gender.FEMALE){
                System.out.println(person);
            }
        }

        System.out.println();

        //DECLARATIVE APPROACH
        List<Person> males = personList.stream()
                .filter(person-> person.age < 50)
                .toList();
        males.forEach(System.out::println);
        System.out.println();
        personList.stream().filter((person)->MALE.equals(person.gender))
                .toList()
                .forEach(System.out::println);
    }

}
