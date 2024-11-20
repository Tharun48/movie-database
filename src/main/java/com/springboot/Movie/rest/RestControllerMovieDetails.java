package com.springboot.Movie.rest;

import com.springboot.Movie.entity.MovieDetails;
import com.springboot.Movie.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class RestControllerMovieDetails {

    Service service;

    @Autowired
    RestControllerMovieDetails(Service service){
        this.service=service;
    }


    //Get the movie details of a particular movie
    @GetMapping("/movie-details/{movieId}")
    public MovieDetails getMovieDetails(@PathVariable int movieId){
        return service.getMovieDetails(movieId);
    }

    //get the list of movies which has rating {movieName,ActorName,directorName,genere}
    @GetMapping("/movie-details/rating/{rating}")
    public List<MovieDetails> getMovieDetailsBasedOnRating(@PathVariable int rating){
        return service.getMovieDetailsBasedOnRating(rating);
    }




}
