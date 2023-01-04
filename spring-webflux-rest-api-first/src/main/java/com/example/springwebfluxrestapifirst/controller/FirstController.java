package com.example.springwebfluxrestapifirst.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class FirstController {

    @GetMapping(value = "getInfos")
    public Flux<String> getInfos() {
        return getFluxString();
    }

    private Flux<String> getFluxString() {

        var nums = new ArrayList<>();
        for (var i = 0; i < 100; i++) {
            nums.add(i);
        }

        var list = nums
                .stream()
                .map(it -> getMonoString())
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
