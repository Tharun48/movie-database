package com.springboot.Movie.service;

import com.springboot.Movie.entity.Actor;
import com.springboot.Movie.entity.Director;
import com.springboot.Movie.entity.Movie;
import com.springboot.Movie.entity.MovieDetails;

import java.util.List;

public interface Service {
    //actor methods
    public int saveActor(Actor actor);
    public List<Actor> findAllActors();
    public Actor getActorById(int actorId);
    public int deleteActor(int actorId);

    //director methods
    public int saveDirector(Director director);
    public List<Director> findAll();
    public Director getDirectorById(int directorId);
    public int deleteDirector(int directorId);

    //movie methods
    public int saveMovie(Movie movie);
    public List<Movie> findAllMovies();
    public Movie getMovieById(int movieId);
    public int deleteMovie(int movieId);

    //movie details
    public MovieDetails getMovieDetails(int movieId);
    public List<MovieDetails> getMovieDetailsBasedOnRating(int rating);
    public List<Movie> getMovieofActorbasedOnRating(int actorId,int rating);

}
