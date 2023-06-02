package com.udeshika.repositories;

import com.udeshika.models.Person;

import java.util.*;

public class PersonRepositoryImpl implements PersonRepository {
    // map contains people to simulate the persistence db
    Map<String, Person> storedPeople;

    public PersonRepositoryImpl() {
        storedPeople = Collections.synchronizedMap(new HashMap<>());
    }

    @Override
    public void save(Person person) {
        storedPeople.put(person.getSocialSecurityNumber(), person);
    }

    @Override
    public Optional<Person> findPerson(String socialSecurityNumber) {
        return Optional.ofNullable(storedPeople.get(socialSecurityNumber));
    }

    @Override
    public void deleteAll() {
        storedPeople.clear();
    }
}