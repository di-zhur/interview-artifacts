package com.example.springwebrestapifourth.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@RestController
public class ExampleController {

    private static AtomicInteger ID = new AtomicInteger(0);

    @GetMapping("getStringValue")
    public String getStringValue() throws InterruptedException {
        log.info("getStringValue - " + Thread.currentThread().getId());
        var id = ID.getAndIncrement();
        Thread.sleep(id * 1000L);
        return "StringValue" + id;
    }

}
