package com.sentuh.jokesapp.data;

import androidx.annotation.NonNull;
import com.sentuh.jokesapp.ApiService;
import com.sentuh.jokesapp.model.Jokes;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokesRepository {

    private final ApiService apiService;
    @Inject
    public JokesRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void searchJokes(String query, final ChuckNorrisCallback callback) {
        Call<Jokes> call = apiService.searchJokes(query);
        call.enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(@NonNull Call<Jokes> call, Response<Jokes> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Jokes> call, Throwable t) {
                callback.onError("Error: " + t.getMessage());
            }
        });
    }

    public interface ChuckNorrisCallback {
        void onSuccess(Jokes response);
        void onError(String errorMessage);
    }
}