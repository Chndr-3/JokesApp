package com.sentuh.jokesapp.di;

import com.sentuh.jokesapp.ApiService;
import com.sentuh.jokesapp.MainViewModel;
import com.sentuh.jokesapp.data.JokesRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    public static ApiService provideApiService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }
    @Provides
    public static JokesRepository provideChuckNorrisRepository(ApiService apiService) {
        return new JokesRepository(apiService);
    }
    @Provides
    public static MainViewModel provideMainViewModel(JokesRepository repository) {
        return new MainViewModel(repository);
    }
}