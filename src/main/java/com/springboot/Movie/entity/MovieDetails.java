package com.springboot.Movie.entity;

public class MovieDetails {
    private String actorName;
    private String directorName;
    private String movieName;
    private int rating;
    private String genere;

    public MovieDetails(){}

    public MovieDetails(String movieName,String actorName, String directorName, int rating, String genere) {
        this.movieName=movieName;
        this.actorName = actorName;
        this.directorName = directorName;
        this.rating = rating;
        this.genere = genere;
    }



    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
