package com.udeshika.services;

import com.udeshika.models.Person;

import java.util.Optional;

public interface PersonService {
    void savePerson(Person personToBeRegistered);

    Optional<Person> getPerson(String socialSecurityNumber);

    Optional<String> getElderChild(String socialSecurityNumber);

    void clearPeopleRegistry();
}