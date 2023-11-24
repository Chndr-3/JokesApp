package com.sentuh.jokesapp;
import com.sentuh.jokesapp.model.Jokes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("jokes/search")
    Call<Jokes> searchJokes(@Query("query") String query);

}

