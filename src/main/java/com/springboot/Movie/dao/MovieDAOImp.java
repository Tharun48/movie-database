package com.springboot.Movie.dao;

import com.springboot.Movie.entity.Actor;
import com.springboot.Movie.entity.Director;
import com.springboot.Movie.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MovieDAOImp implements MovieDAO{
    EntityManager entityManager;

    @Autowired
    MovieDAOImp(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    public int saveMovie(Movie movie) {
        Movie dbmovie  = entityManager.merge(movie);
        return dbmovie.getMovieId();
    }



    @Override
    public List<Movie> findAll() {
        TypedQuery<Movie> result = entityManager.createQuery("From Movie",Movie.class);
        return result.getResultList();
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie;
        movie = entityManager.find(Movie.class,movieId);
        if(movie==null){
            throw new IllegalArgumentException("movie not found for the id  = " + movieId);
        }
        return movie;
    }

    @Override
    public int deleteMovie(int movieId) {
        Movie movie = getMovieById(movieId);
        if(movie!=null) {
            entityManager.remove(movie);
        }
        else{
            throw new IllegalArgumentException("movie not found for the id = " + movieId);
        }
        return movieId;
    }
}
