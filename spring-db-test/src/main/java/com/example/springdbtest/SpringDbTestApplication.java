package com.example.springdbtest;

import com.example.springdbtest.service.DirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDbTestApplication implements ApplicationRunner {

    private DirService dirService;

    @Autowired
    public void setDirService(DirService dirService) {
        this.dirService = dirService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDbTestApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dirService.execute();
    }
}
