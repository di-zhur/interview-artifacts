package com.example.springdbtest.repository;

import com.example.springdbtest.entity.Dir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirRepository extends JpaRepository<Dir, Integer> {

}
