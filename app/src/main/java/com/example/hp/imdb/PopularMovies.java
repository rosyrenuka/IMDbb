package com.example.hp.imdb;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by HP on 26-03-2018.
 */

 public class PopularMovies {

    @SerializedName("results")
    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
