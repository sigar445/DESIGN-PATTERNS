package org.sigar.EffectiveJava.FunctionalInterfaces;

import java.util.List;

import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.FEMALE;
import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.MALE;

public class Constants {

    public static List<Person> personList =  List.of(
            new Person("ram", MALE,43),
            new Person("amyra", FEMALE,65),
            new Person("rasfm", MALE,18),
            new Person("amy", FEMALE,45),
            new Person("abram", MALE,67),
            new Person("aeredvmy", FEMALE,45),
            new Person("rfsdam", MALE,49),
            new Person("aermy", FEMALE,78));


}
