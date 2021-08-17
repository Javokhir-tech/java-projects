package com.javokhir.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.javokhir.spring")
public class MyConfig {

    @Bean
    public RestTemplate restTemplate() {    // used to convert HTTP response to java objects
        return new RestTemplate();
    }
}
