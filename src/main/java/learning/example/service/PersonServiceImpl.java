package learning.example.service;

import learning.example.PeopleData;
import learning.example.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    // == constants //
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    // == fields ==
    private final PeopleData data;

    // == constructor ==
    @Autowired
    public PersonServiceImpl(PeopleData data) {
        this.data = data;
    }

    // == public methods ==
    //service calls logic in People Data Class defined to act on the
    //Array List of Data

    @Override
    public void addPerson(Person toAdd) {
        data.addPerson(toAdd);
    }

    @Override
    public void removePerson(int id) {
        data.removePerson(id);
    }

    @Override
    public Person getPerson(int id) {
        return data.getPerson(id);
    }

    @Override
    public void updatePerson(Person toUpdate) {
        data.updatePerson(toUpdate);

    }

    @Override
    public PeopleData getData() {
        return data;
    }
}
