package com.springboot.Movie.dao;

import com.springboot.Movie.entity.Director;

import java.util.List;

public interface DirectorDAO {
    public int saveDirector(Director director);
    public List<Director> findAll();
    public Director getDirectorById(int directorId);
    public int deleteDirector(int directorId);
}
