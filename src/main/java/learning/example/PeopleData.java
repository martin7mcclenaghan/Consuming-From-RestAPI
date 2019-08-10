package learning.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Component
public class PeopleData {

    //== constants ==
    private static final Logger log = LoggerFactory.getLogger(PeopleData.class);

    // == fields ==
    private final List<Person> personList;
    private final DataArray dataArray;

    //== constructor ==
    @Autowired
    public PeopleData(DataArray dataArray) {
        this.personList = Arrays.asList(dataArray.getPeopleArray());
        this.dataArray = dataArray;
        log.info("Person List = {}", personList);
    }

    // == public methods ==
    public List<Person> getPersonList() {
        return Collections.unmodifiableList(personList);
    }

    public void addPerson (Person toAdd){

        if(toAdd == null){
            throw new NullPointerException("toAdd is a required parameter");
        }

        int currentLastId = personList.size();
        toAdd.setId(currentLastId + 1);
        personList.add(toAdd);

    }

    public void removePerson(int id){
        ListIterator<Person> personListIterator = personList.listIterator();

        while(personListIterator.hasNext()){

            Person person = personListIterator.next();

            if(person.getId() == id){
                personListIterator.remove();
                break;
            }
        }
    }

    public Person getPerson (int id){

        for(Person person : personList){
            if(person.getId() == id){
                return person;
            }
        }

        return null;
    }

    public void updatePerson(Person toUpdate){

        if(toUpdate == null){
            throw new NullPointerException("toUpdate is a required parameter");
        }

        ListIterator<Person> personListIterator = personList.listIterator();

        while(personListIterator.hasNext()){
            Person person = personListIterator.next();

            if(person.equals(toUpdate)){
                personListIterator.set(toUpdate);
                break;
            }
        }
    }



}
