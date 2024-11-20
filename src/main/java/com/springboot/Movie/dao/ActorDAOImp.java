package com.springboot.Movie.dao;

import com.springboot.Movie.entity.Actor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ActorDAOImp implements ActorDAO{

    EntityManager entityManager;

    @Autowired
    ActorDAOImp(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    public int saveActor(Actor actor) {
        Actor savedactor = entityManager.merge(actor);
        return savedactor.getActorId();
    }


    @Override
    public List<Actor> findAll() {
        TypedQuery<Actor> result = entityManager.createQuery("From Actor",Actor.class);
        return result.getResultList();
    }

    @Override
    public Actor getActorById(int actorId) {
        Actor actor = null;
        actor  = entityManager.find(Actor.class,actorId);
       if(actor==null) {
           throw new IllegalArgumentException("actor not found for the id= " + actorId);
       }
       return actor;
    }

    @Override
    public int deleteActor(int actorId) {
        Actor actor = getActorById(actorId);
        if(actor!=null) {
            entityManager.remove(actor);
        }
        else{
            throw new IllegalArgumentException("actor not found for the id = " + actorId);
        }
        return actorId;
    }
}
