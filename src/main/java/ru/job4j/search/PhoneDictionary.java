package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();

        Predicate<Person> hasName = (person) ->
                person.getName().contains(key);
        Predicate<Person> hasSurname = (person) ->
                person.getSurname().contains(key);
        Predicate<Person> hasPhone = (person) ->
                person.getPhone().contains(key);
        Predicate<Person> hasAddress = (person) ->
                person.getAddress().contains(key);
        Predicate<Person> combine = hasName.or(hasSurname).or(hasPhone).or(hasAddress);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}
