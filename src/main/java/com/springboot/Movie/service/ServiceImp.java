package com.springboot.Movie.service;

import com.springboot.Movie.dao.ActorDAO;
import com.springboot.Movie.dao.DirectorDAO;
import com.springboot.Movie.dao.MovieDAO;
import com.springboot.Movie.entity.Actor;
import com.springboot.Movie.entity.Director;
import com.springboot.Movie.entity.Movie;
import com.springboot.Movie.entity.MovieDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
@org.springframework.stereotype.Service
public class ServiceImp implements Service{

    ActorDAO actorDAO;
    DirectorDAO directorDAO;
    MovieDAO movieDAO;
    EntityManager entityManager;

    ServiceImp(ActorDAO actorDAO,DirectorDAO directorDAO,MovieDAO movieDAO,EntityManager entityManager){
        this.actorDAO=actorDAO;
        this.movieDAO=movieDAO;
        this.directorDAO=directorDAO;
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public int saveActor(Actor actor) {
        return actorDAO.saveActor(actor);
    }

    @Override
    public List<Actor> findAllActors() {
        return actorDAO.findAll();
    }

    @Override
    public Actor getActorById(int actorId) {
        return actorDAO.getActorById(actorId);
    }

    @Override
    @Transactional
    public int deleteActor(int actorId) {
        return actorDAO.deleteActor(actorId);
    }

    @Override
    @Transactional
    public int saveDirector(Director director) {
        return directorDAO.saveDirector(director);
    }



    @Override
    public List<Director> findAll() {
        return directorDAO.findAll();
    }

    @Override
    public Director getDirectorById(int directorId) {
        return directorDAO.getDirectorById(directorId);
    }

    @Override
    @Transactional
    public int deleteDirector(int directorId) {
        return directorDAO.deleteDirector(directorId);
    }

    @Override
    @Transactional
    public int saveMovie(Movie movie) {
        int actorId = movie.getActorId();
        int directorId = movie.getDirectorId();
        Actor actor  = getActorById(actorId);
        Director director = getDirectorById(directorId);
        return movieDAO.saveMovie(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieDAO.findAll();
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieDAO.getMovieById(movieId);
    }

    @Override
    @Transactional
    public int deleteMovie(int movieId) {
        return movieDAO.deleteMovie(movieId);
    }

    @Override
    public MovieDetails getMovieDetails(int movieId) {
        Movie movie = getMovieById(movieId);
        Actor actor = getActorById(movie.getActorId());
        Director director = getDirectorById(movie.getDirectorId());

        String movieName=movie.getMovieName();
        String actorName = actor.getActorName();
        String directorName = director.getDirectorName();
        int rating = movie.getRating();
        String genere = movie.getCategory();
        MovieDetails movieDetails = new MovieDetails(movieName,actorName,directorName,rating,genere);
        return movieDetails;
    }

    @Override
    public List<MovieDetails> getMovieDetailsBasedOnRating(int rating) {

        if(rating>5) {
            throw new InputMismatchException("rating cannot be greater than 5");
        }

        if(rating<0) {
            throw new InputMismatchException("rating cannot be lesser than 0");
        }


        List<Movie> list = movieDAO.findAll();
        List<MovieDetails> movieDetails = new ArrayList<>();
        for(Movie movieEle : list ) {
            int movieId = movieEle.getMovieId();
            Movie movie = getMovieById(movieId);
            if(movie.getRating()>=rating) {
                Actor actor = getActorById(movie.getActorId());
                Director director = getDirectorById(movie.getDirectorId());
                String movieName=movie.getMovieName();
                String actorName = actor.getActorName();
                String directorName = director.getDirectorName();
                String genere = movie.getCategory();
                int movieRating = movie.getRating();
                MovieDetails movieDetailsSingle = new  MovieDetails(movieName,actorName,directorName, movieRating,genere);
                movieDetails.add(movieDetailsSingle);
            }
        }
        return movieDetails;
    }

    @Override
    public List<Movie> getMovieofActorbasedOnRating(int actorId, int rating) {

        if(rating>5) {
            throw new InputMismatchException("rating cannot be greater than 5");
        }

        if(rating<0) {
            throw new InputMismatchException("rating cannot be lesser than 0");
        }

        TypedQuery<Movie> result = entityManager.createQuery("From Movie Where actorId=:thedata1 and rating>=:thedata2",Movie.class);
        result.setParameter("thedata1",actorId);
        result.setParameter("thedata2",rating);
        return result.getResultList();
    }
}
