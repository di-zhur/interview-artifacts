package com.example.springwebfluxrestapifirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients
public class SpringWebfluxRestApiFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxRestApiFirstApplication.class, args);
    }

}
