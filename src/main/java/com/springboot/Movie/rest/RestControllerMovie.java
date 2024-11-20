package com.springboot.Movie.rest;

import com.springboot.Movie.entity.Movie;
import com.springboot.Movie.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerMovie {
    Service service;

    @Autowired
    RestControllerMovie(Service service){
        this.service=service;
    }

    @PostMapping("/movie")
    public int save(@RequestBody Movie movie) {
        movie.setMovieId(0);
        return service.saveMovie(movie);
    }

    @PutMapping("/movie")
    public int modify(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }

    @GetMapping("/movie")
    public List<Movie> fetchMovie(){
        return service.findAllMovies();
    }

    @GetMapping("/movie/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return service.getMovieById(movieId);
    }


    @DeleteMapping("/movie/{movieId}")
    public int deleteMovie(@PathVariable int movieId){
        return service.deleteMovie(movieId);
    }

}
