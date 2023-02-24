package com.example.springwebfluxrestapifirst.service;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repa extends ReactiveCrudRepository<String, Integer> {
}