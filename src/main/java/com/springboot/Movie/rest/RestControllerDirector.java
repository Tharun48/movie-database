package com.springboot.Movie.rest;

import com.springboot.Movie.entity.Director;
import com.springboot.Movie.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerDirector {

    Service service;

    @Autowired
    RestControllerDirector(Service service){
        this.service=service;
    }

    @PostMapping("/director")
    public int saveDirector(@RequestBody Director director){
        return service.saveDirector(director);
    }

    @PutMapping("/director")
    public int modifyDirector(@RequestBody Director director){
        return service.saveDirector(director);
    }

    @GetMapping("/director")
    public List<Director> fetchDirector(){
        return service.findAll();
    }

    @GetMapping("/director/{directorId}")
    public Director getDirector(@PathVariable int directorId){
        return service.getDirectorById(directorId);
    }

    @DeleteMapping("director/{directorId}")
    public int deleteDirector(@PathVariable int directorId){
        return service.deleteDirector(directorId);
    }

}
