package learning.example.controller;

import learning.example.PeopleData;
import learning.example.Person;
import learning.example.service.PersonService;
import learning.example.util.AttributeNames;
import learning.example.util.Mappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping(Mappings.LIST)
    public String openList (Model model){
        log.info("Model = {}", model);
        return "item_list";
    }

    //method used to create new item or edit existing
    @GetMapping("addItem")
    public String addEditItem (@RequestParam(required = false, defaultValue = "0") int id, Model model){
        log.info("Editing item with id {}", id);
        Person person = personService.getPerson(id);

        if(person == null){
            person = new Person("", "", "");
        }

        model.addAttribute("newPerson", person);
        return "add_item";
    }

   //method processes form from add_item page
    @PostMapping("addItem")
    public String processItem (@ModelAttribute("newPerson") Person personToAdd){
        log.info("Added Person from form = {}", personToAdd);
        personService.addPerson(personToAdd);
        return "redirect:/" + Mappings.LIST;
    }

    //method adds selected Person as model attribute and returns view_item
    @GetMapping("viewItem")
    public String viewItem (@RequestParam int id, Model model){
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "view_item";
    }

    //method deletes selected Person from the ArrayList and redirects to the item_list view
    @GetMapping("deleteItem")
    public String deleteItem (@RequestParam int id){
        log.info("Deleting Person with id {}", id);
        personService.removePerson(id);
        return "redirect:/" + Mappings.LIST;
    }



}
