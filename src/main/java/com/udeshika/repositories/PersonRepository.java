package com.udeshika.repositories;

import com.udeshika.models.Person;

import java.util.Optional;

public interface PersonRepository {
    void save(Person person);

    Optional<Person> findPerson(String socialSecurityNumber);

    void deleteAll();
}
