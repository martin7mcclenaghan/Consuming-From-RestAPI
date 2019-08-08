package learning.example.config;

import learning.example.RestAnn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan(basePackages = "com.example")
public class RestConfig {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(RestConfig.class);

    // == Bean method ==
    @Bean
    @RestAnn
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }





}
