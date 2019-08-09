package learning.example.service;

import learning.example.PeopleData;
import learning.example.Person;

public interface PersonService {

    void addPerson(Person toAdd);
    void removePerson (int id);
    Person getPerson (int id);
    void updatePerson (Person toUpdate);
    PeopleData getData();
}
