package com.example.springwebfluxrestapifirst.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@Component
@ReactiveFeignClient(value = "movie-service", url = "http://localhost:8081")
public interface MyClient {

    @GetMapping("getStringValue")
    Mono<String> getMonoString();

}
