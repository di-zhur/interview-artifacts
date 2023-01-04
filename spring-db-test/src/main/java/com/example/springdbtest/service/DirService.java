package com.example.springdbtest.service;

import com.example.springdbtest.entity.Dir;
import com.example.springdbtest.repository.DirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DirService {

    private final DirRepository dirRepository;

    @Autowired
    public DirService(DirRepository dirRepository) {
        this.dirRepository = dirRepository;
    }

    @Transactional
    public void execute() {
        var dir = dirRepository.findById(1).orElseThrow();
        dir.setName("new_dir_name");
        dirRepository.save(dir);
        dirRepository.deleteById(2);
        throw new RuntimeException();
    }

    public void loadDir() {
        var dirs = List.of(
                createDir("Dir1"),
                createDir("Dir2"),
                createDir("Dir3"),
                createDir("Dir4"),
                createDir("Dir5"),
                createDir("Dir6")
        );

        dirRepository.saveAll(dirs);
    }

    private Dir createDir(String name) {
        Dir dir = new Dir();
        dir.setName(name);
        return dir;
    }

}
