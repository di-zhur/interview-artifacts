package com.example.springwebfluxrestapifirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;

@RestController
public class FirstController {

    @Autowired
    private MyClient myClient;

    @GetMapping(value = "getInfos")
    public Flux<String> getInfos() {
        return getFluxString();
    }

    PostgresqlConnectionFactory connectionFactory = new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
            .host(…)
            .database(…)
            .username(…)
            .password(…).build());

    R2dbcEntityTemplate template = new R2dbcEntityTemplate(connectionFactory);

    Mono<Integer> update = template.update(Person.class)
            .inTable("person_table")
            .matching(query(where("firstname").is("John")))
            .apply(update("age", 42));

    Flux<Person> all = template.select(Person.class)
            .matching(query(where("firstname").is("John")
                    .and("lastname").in("Doe", "White"))
                    .sort(by(desc("id"))))
            .all();

    private Flux<String> getFluxString() {


        var nums = new ArrayList<>();
        for (var i = 0; i < 100; i++) {
            nums.add(i);
        }

        var list = nums
                .stream()
                .map(it -> myClient.getMonoString())
                .toList();

        return Flux.merge(list);
    }

    private Mono<String> getMonoString() {
        return Mono.fromCallable(
                () -> {
                    RestTemplate restTemplate = new RestTemplate();
                    String fooResourceUrl
                            = "http://localhost:8081/getStringValue";
                    return restTemplate.getForEntity(fooResourceUrl, String.class).getBody();
                })
                .subscribeOn(Schedulers.boundedElastic());
    }
}
