package learning.example.service;

import learning.example.model.Person;
import learning.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    // == fields ==
    private PersonRepository personRepository;

    // == constructor ==
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    // == implemented public methods ==
    @Override
    public Person createPerson(Person toAdd) {
        log.info("Creating new person record: {}", toAdd);
        return personRepository.save(toAdd);
    }

    @Override
    public Person readPerson(int id) {
        log.info("Reading record with id: {}", id);
        return personRepository.getOne(id);
    }

    @Override
    public Person updatePerson(Person toUpdate) {
        log.info("Updating person record: {}", toUpdate);
        return personRepository.save(toUpdate);
    }

    @Override
    public void deletePerson(int id) {
        log.info("Deleting person record with id: {}", id);
        personRepository.deleteById(id);

    }

    @Override
    public List<Person> readAll() {
        log.info("Returning all records");
        return personRepository.findAll();
    }
}
