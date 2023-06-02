package com.udeshika;

import com.udeshika.models.Child;
import com.udeshika.models.Person;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.udeshika.services.PersonServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonServiceImplTest {
    PersonServiceImpl personService = new PersonServiceImpl();
    static Person testPersonWithAChild;
    static Person testPersonWithoutKids;

    @BeforeClass
    public static void setUp() {
        testPersonWithAChild = new Person("199004201111", "TestPersonName", "TestSpouseName",
                List.of(new Child("TestChildName1", 5), new Child("TestChildName2", 10), new Child("TestChildName3", 3)));
        testPersonWithoutKids = new Person("199004201111", "TestPersonName", "TestSpouseName", Collections.emptyList());
    }

    @Before
    public void beforeEachTest() {
        personService.clearPeopleRegistry();
    }

    @Test
    public void registered_person_should_be_retrieved() {
        personService.savePerson(testPersonWithAChild);
        var actualResult = personService.getPerson(testPersonWithAChild.getSocialSecurityNumber()).get();
        assertEquals(testPersonWithAChild.getSocialSecurityNumber(), actualResult.getSocialSecurityNumber());
    }

    @Test
    public void for_a_person_without_kids_elder_child_name_should_be_empty() {
        personService.savePerson(testPersonWithoutKids);
        var actualResult = personService.getElderChild(testPersonWithoutKids.getSocialSecurityNumber()).isEmpty();
        assertTrue(actualResult);
    }

    @Test
    public void for_a_person_with_kids_elder_child_name_should_returned() {
        personService.savePerson(testPersonWithAChild);
        var actualResult = personService.getElderChild(testPersonWithAChild.getSocialSecurityNumber()).get();
        assertEquals(testPersonWithAChild.getChildren().get(1).getName(), actualResult);
    }
}
