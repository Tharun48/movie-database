package com.springboot.Movie.dao;

import com.springboot.Movie.entity.Actor;

import java.util.List;

public interface ActorDAO {
    public int saveActor(Actor actor);
    public List<Actor> findAll();
    public Actor getActorById(int actorId);
    public int deleteActor(int actorId);
}
