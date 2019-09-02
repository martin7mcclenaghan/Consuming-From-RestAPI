package learning.example.service;

import learning.example.Person;

import java.util.List;

public interface PersonService {

    void createPerson(Person toAdd);

    Person readPerson (int id);

    void updatePerson (Person toUpdate);

    void deletePerson (int id);

    List<Person> readAll();
}
