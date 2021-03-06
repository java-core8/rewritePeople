package com.tcreator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        persons.stream().
                filter(x -> x.getAge() < 18)
                .count();
        List<String> collectionArmy = persons.stream()
                .filter(x -> x.getAge() > 18)
                .map(x -> x.getName() + " " + x.getFamily())
                .collect(Collectors.toList());
        List<Person> furhterPeopleSorted = persons.stream()
                .filter(x -> x.getEducation().equals(Education.FURTHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }
}
