package learning.example.controller;

import learning.example.PeopleData;
import learning.example.service.PersonService;
import learning.example.util.AttributeNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @ModelAttribute(AttributeNames.PEOPLE_DATA)
    public PeopleData peopleData (){
        return personService.getData();
    }

    // == handler methods ==
    @GetMapping("list")
    public String openList (Model model){
        log.info("Model = {}", model);
        return "item_list";
    }


}
