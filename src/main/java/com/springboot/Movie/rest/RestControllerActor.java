package com.springboot.Movie.rest;

import com.springboot.Movie.dao.ActorDAO;
import com.springboot.Movie.entity.Actor;
import com.springboot.Movie.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerActor {

    Service service;
    ActorDAO actorDAO;

    @Autowired
    RestControllerActor(Service service){
        this.service=service;
    }


    @PostMapping("/actor")
    public int saveActor(@RequestBody Actor actor) {
        actor.setActorId(0);
        return service.saveActor(actor);
    }

    @PutMapping("/actor")
    public int modifyActor(@RequestBody Actor actor) {
        return service.saveActor(actor);
    }

    @GetMapping("actor")
    public List<Actor> fetchActors() {
        return service.findAllActors();
    }

    @GetMapping("/actor/{actorId}")
    public Actor getActor(@PathVariable int actorId){
        return service.getActorById(actorId);
    }


    @DeleteMapping("actor/{actorId}")
    public int deleteActor(@PathVariable int actorId){
        return service.deleteActor(actorId);
    }

}
