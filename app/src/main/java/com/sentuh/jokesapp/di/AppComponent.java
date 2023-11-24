package com.sentuh.jokesapp.di;

import com.sentuh.jokesapp.ApiService;
import com.sentuh.jokesapp.MainViewModel;
import com.sentuh.jokesapp.data.JokesRepository;
import dagger.Component;


@Component(modules = {AppModule.class})
public interface AppComponent {
    ApiService chuckNorrisApiService();
    JokesRepository chuckNorrisRepository();
    MainViewModel mainViewModel();
    @Component.Builder
    interface Builder {
        AppComponent build();
    }
}
