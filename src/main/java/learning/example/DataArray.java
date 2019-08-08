package learning.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class DataArray {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(DataArray.class);

    // == fields ==
    private final RestTemplate restTemplate;
    public People [] peopleArray;

    // == constructors ==
    @Autowired
    public DataArray(@RestAnn RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // == init ==
    @PostConstruct
    public void getDataArray (){
        peopleArray = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", People[].class);

        for(People person : peopleArray){

            log.info(person.toString());
        }

    }



}
