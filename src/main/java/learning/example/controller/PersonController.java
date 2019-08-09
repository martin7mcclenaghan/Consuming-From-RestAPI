package learning.example.controller;

import learning.example.PeopleData;
import learning.example.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PersonController {

    // == constants //
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    // == fields ==
    private final PersonService personService;

    // == constructor ==
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // == model attribute ==
    @ModelAttribute
    public PeopleData peopleData (){
        return personService.getData();
    }

    // == handler methods ==


}
