package ru.eshmakar.spring.rest.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "ru.eshmakar.spring.rest.client")

public class MyConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
