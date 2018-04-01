package com.example.hp.imdb;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by HP on 25-03-2018.
 */

 public interface Movie_Api {

     @GET("{type}?api_key=240b752ab9c0cb8011560c2f8338adc1")

     Call<PopularMovies> getPopularMovies(@Path("type") String type);
    // Call<Movie> getMovie();

    @GET("{ID}?api_key=240b752ab9c0cb8011560c2f8338adc1")
    Call<Movie> getMovieDetails(@Path("ID") Long idMovie);


    @GET("{ID}/images?api_key=240b752ab9c0cb8011560c2f8338adc1")
    Call<Image> getImagesOfMovie(@Path("ID") Long idMovie);


    @GET("{ID}/credits?api_key=240b752ab9c0cb8011560c2f8338adc1")
      Call<TopCast> getTopCast(@Path("ID") Long idMovie);

   }
