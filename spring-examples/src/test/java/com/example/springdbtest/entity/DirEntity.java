package com.example.springdbtest.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Dir", schema = "public", catalog = "postgres")
public class DirEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    @Basic
    @Column(name = "Name")
    private String name;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirEntity dirEntity = (DirEntity) o;
        return id == dirEntity.id && Objects.equals(name, dirEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
