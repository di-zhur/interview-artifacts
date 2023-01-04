package com.example.springdbtest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Dir")
public class Dir {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Name")
    private String name;

}
