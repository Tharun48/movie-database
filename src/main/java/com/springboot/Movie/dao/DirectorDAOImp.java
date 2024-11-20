package com.springboot.Movie.dao;

import com.springboot.Movie.entity.Actor;
import com.springboot.Movie.entity.Director;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.List;
@Repository
public class DirectorDAOImp implements DirectorDAO{

    EntityManager entityManager;

    @Autowired
    DirectorDAOImp(EntityManager entityManager) {
        this.entityManager=entityManager;
    }


    @Override
    public int saveDirector(Director director) {
        Director dbDirector = entityManager.merge(director);
        return dbDirector.getDirectorId();
    }


    @Override
    public List<Director> findAll() {
        TypedQuery<Director> result = entityManager.createQuery("From Director",Director.class);
        return result.getResultList();
    }

    @Override
    public Director getDirectorById(int directorId) {
        Director director;
        director = entityManager.find(Director.class,directorId);
        if(director==null) {
            throw new IllegalArgumentException("director not found for the id = " + directorId);
        }
        return director;
    }

    @Override
    public int deleteDirector(int directorId) {
        Director director = getDirectorById(directorId);
        if(director!=null) {
            entityManager.remove(director);
        }
        else{
            throw new IllegalArgumentException("director not found for the id = " + directorId);
        }
        return directorId;
    }
}
