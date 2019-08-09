package learning.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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


}
