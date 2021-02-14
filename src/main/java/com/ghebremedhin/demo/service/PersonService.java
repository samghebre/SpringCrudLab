package com.ghebremedhin.demo.service;

import com.ghebremedhin.demo.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Person person);

    List<Person> getAllPerson();

    Person getPersonById(long personId);

    void deletePerson(long id);
}
