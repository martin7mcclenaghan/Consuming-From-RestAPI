package learning.example.controller;

import learning.example.Person;
import learning.example.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    @ModelAttribute("people")
    public List<Person> peopleData() {
        return personService.readAll();
    }

    // == handler methods ==
    //method to show list of records from db
    @GetMapping("list")
    public String openList(Model model) {
        log.info("Model = {}", model);
        return "person_list";
    }

    //method used to create new item
    @GetMapping("addPerson")
    public String addEditItem(Model model) {

        log.info("New Person object created");
        Person person = new Person();
        log.info("Adding new Person object as model attribute {}", person);
        model.addAttribute("newPerson", person);
        return "create_person";
    }

    //method processes form from add_item page
    @PostMapping("addPerson")
    public String processItem(@ModelAttribute("newPerson") Person person) {

        log.info("New Person added from form {}", person);
        personService.createPerson(person);
        return "redirect:/list";
    }

    //method adds selected Person as model attribute and returns view_item
    @GetMapping("viewPerson")
    public String viewPerson (@RequestParam int id, Model model){
        Person person = personService.readPerson(id);
        log.info("Showing person with id {}, {}", id, person);
        model.addAttribute("person", person);
        return "view_person";
    }



}
