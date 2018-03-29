package com.example.hp.imdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detail_Movie extends AppCompatActivity {

    TextView Tmoviename;
    TextView Toverview;
    TextView Ttagline;
    TextView Tbudget;
     TextView Tadult;
     TextView Tstatus;
     TextView Tvideo;
     TextView Tvote;
     TextView Tlanguage;
     TextView Trelease;


       ImageView TbackdropPath;
       ImageView TposterPath;

       long idMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__movie);

        Intent intent=getIntent();
        idMovie=intent.getLongExtra("ID",0);

        Tadult=findViewById(R.id.adult);
        Tstatus=findViewById(R.id.status);
        Tlanguage=findViewById(R.id.language);
        Trelease=findViewById(R.id.date);
        Tvote=findViewById(R.id.vote);
        Tvideo=findViewById(R.id.video);
        Tmoviename=findViewById(R.id.moviename);
        Toverview=findViewById(R.id.overview);
        Toverview.setMovementMethod(new ScrollingMovementMethod());
        Ttagline=findViewById(R.id.tagline);
        Tbudget=findViewById(R.id.budget);

        TbackdropPath=findViewById(R.id.backdrop);
        TposterPath=findViewById(R.id.posterpath);

        fetchDetailsOfMOVIES();
    }

    private void fetchDetailsOfMOVIES() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/")
                              .addConverterFactory(GsonConverterFactory.create()).build();


           Movie_Api movie_api = retrofit.create(Movie_Api.class);

        Call<Movie> call = movie_api.getMovieDetails(idMovie);

                 call.enqueue(new Callback<Movie>() {
                     @Override
                     public void onResponse(Call<Movie> call, Response<Movie> response) {

                         Movie MovieDetail = response.body();
                         if(MovieDetail!=null)
                         {
                             // get all values

                            String moviename = MovieDetail.getMovieName();
                             String overview = MovieDetail.getOverview();
                             String tagline = MovieDetail.getTagline();
                             Long budget = MovieDetail.getBudget();
                           Boolean adult = MovieDetail.getAdult();
                             String status = MovieDetail.getStatus();
                             Boolean video = MovieDetail.getVideo();
                             double vote = MovieDetail.getVote();
                             String language = MovieDetail.getLanguage();
                             String release = MovieDetail.getRelease();


                             String backdropPath = MovieDetail.getBackdropPath();
                            String posterPath = MovieDetail.getPosterPath();

                         // set all values in views


                            Tstatus.setText(status);
                            Ttagline.setText(tagline);
                            Tvideo.setText(video+"");
                            Tlanguage.setText(language);
                            Tvote.setText(vote+"");
                            Trelease.setText(release);
                            Tadult.setText(adult+"");
                            Tbudget.setText(budget+"");
                            Tmoviename.setText(moviename);
                            Toverview.setText(overview);

                             Picasso.get().load("https://image.tmdb.org/t/p/w500/"+backdropPath).into(TbackdropPath);

                             Picasso.get().load("https://image.tmdb.org/t/p/w500/"+posterPath).into(TposterPath);

                             Toast.makeText(Detail_Movie.this, "Downloaded successfully", Toast.LENGTH_SHORT).show();
                         }
                         else{
                             Toast.makeText(Detail_Movie.this, "NULL !!!", Toast.LENGTH_SHORT).show();
                         }
                     }

                     @Override
                     public void onFailure(Call<Movie> call, Throwable t) {

                         Toast.makeText(Detail_Movie.this, "FAILED TO LOAD", Toast.LENGTH_SHORT).show();
                     }
                 });

    }


}
