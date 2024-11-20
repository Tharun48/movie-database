package com.springboot.Movie.dao;

import com.springboot.Movie.entity.Movie;

import java.util.List;

public interface MovieDAO {
    public int saveMovie(Movie movie);
    public List<Movie> findAll();
    public Movie getMovieById(int movieId);
    public int deleteMovie(int movieId);
}
