package com.udeshika.services;

import com.udeshika.repositories.PersonRepositoryImpl;
import com.udeshika.models.Child;
import com.udeshika.models.Person;
import com.udeshika.repositories.PersonRepository;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonServiceImpl implements PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private final PersonRepository repository;

    public PersonServiceImpl() {
        this.repository = new PersonRepositoryImpl();
    }

    /**
     * Registers a new person
     *
     * @param person the person to be registered
     */
    public void savePerson(Person person) {
        // assumption: person details will be validated in the endpoint (ex: validity of the socialSecurityNumber)
        repository.save(person);
        logger.log(Level.INFO, "Person registered: {0}", person.getSocialSecurityNumber());
    }

    /**
     * Find a person by the socialSecurityNumber
     *
     * @param socialSecurityNumber the social security number of the person.
     * @return the found person or empty
     */
    public Optional<Person> getPerson(String socialSecurityNumber) {
        Optional<Person> foundPerson = repository.findPerson(socialSecurityNumber);
        if (foundPerson.isEmpty()) {
            logger.log(Level.INFO, "Could not retrieve the person: {0}", socialSecurityNumber);
        }
        return foundPerson;
    }

    /**
     * Returns the name of the elder child of the person.
     *
     * @param socialSecurityNumber the social security number of the person.
     * @return the elder child's name of the person if they exist, else empty
     */
    public Optional<String> getElderChild(String socialSecurityNumber) {
        // assumption: The respective endpoint can return the elder child found through this service method along with
        // the social security number. Hence, no need to pass the social security number from this method.
        Optional<Person> foundPerson = getPerson(socialSecurityNumber);

        if (foundPerson.isEmpty() || foundPerson.get().getChildren().isEmpty()) {
            return Optional.empty();
        }

        Person person = foundPerson.get();
        if (person.getChildren().size() == 1) {
            return Optional.of(person.getChildren().get(0).getName());
        }

        // find the eldest child when there are more than 1 child for the person
        Child elderChild = person.getChildren().get(0);
        for (Child child : person.getChildren()) {
            if (child.getAge() > elderChild.getAge()) {
                elderChild = child;
            }
        }

        return Optional.of(elderChild.getName());
    }

    @Override
    public void clearPeopleRegistry() {
        repository.deleteAll();
    }
}
