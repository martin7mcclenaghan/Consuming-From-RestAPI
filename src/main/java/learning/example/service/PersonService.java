package learning.example.service;

import learning.example.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person toAdd);

    Person readPerson (int id);

    Person updatePerson (Person toUpdate);

    void deletePerson (int id);

    List<Person> readAll();
}
