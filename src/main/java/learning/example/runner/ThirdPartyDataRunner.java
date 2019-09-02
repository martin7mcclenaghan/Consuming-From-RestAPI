package learning.example.runner;

import learning.example.model.Person;
import learning.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
@Component
public class ThirdPartyDataRunner implements CommandLineRunner {

    // == constants ==
    private Logger log = LoggerFactory.getLogger(ThirdPartyDataRunner.class);

    //== fields ==
    private final RestTemplate restTemplate;
    private PersonRepository personRepository;

    // == constructors ==
    public ThirdPartyDataRunner(RestTemplate restTemplate, PersonRepository personRepository) {
        this.restTemplate = restTemplate;
        this.personRepository = personRepository;
    }

    // == implemented methods ==
    @Override
    public void run(String... args) throws Exception {

        log.info("Getting data from jsonplaceholder");
        Person[] peopleArray = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", Person[].class);

        if (peopleArray == null) {
            throw new RuntimeException("Unable to get data");
        }
        personRepository.saveAll(Arrays.asList(peopleArray));
    }
}
