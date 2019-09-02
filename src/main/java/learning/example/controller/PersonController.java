package learning.example.controller;

import learning.example.model.Person;
import learning.example.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //method used to create new person
    @GetMapping("addPerson")
    public String createPerson(Model model) {

        log.info("New Person object created");
        Person person = new Person();
        log.info("Adding new Person object as model attribute {}", person);
        model.addAttribute("newPerson", person);
        return "create_person";
    }

    //method processes form from create_person page
    @PostMapping("addPerson")
    public String processPerson(@ModelAttribute("newPerson") Person person) {

        log.info("New Person added from form {}", person);
        personService.createPerson(person);
        return "redirect:/list";
    }

    //method adds selected Person as model attribute and returns view_person
    @GetMapping("viewPerson")
    public String viewPerson (@RequestParam int id, Model model){
        Person person = personService.readPerson(id);
        log.info("Showing person with id {}, {}", id, person);
        model.addAttribute("person", person);
        return "view_person";
    }

    @GetMapping("editPerson")
    public String updatePerson(@RequestParam int id, Model model) {
        Person person = personService.readPerson(id);
        log.info("Editing person with id {}, {}", id, person);
        model.addAttribute("person", person);
        return "update_person";
    }


    @PostMapping("editPerson")
    public String processUpdatePerson(@ModelAttribute("person") Person person) {
        log.info("Person updated from form {}", person);
        personService.updatePerson(person);
        return "redirect:/list";
    }

    @GetMapping("deletePerson")
    public String deletePerson (@RequestParam int id) {
        log.info("Deleting Person with id {}", id);
        personService.deletePerson(id);
        return "redirect:/list";
    }




}
