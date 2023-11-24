package com.sentuh.jokesapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.sentuh.jokesapp.data.JokesRepository;
import com.sentuh.jokesapp.model.Jokes;
import com.sentuh.jokesapp.model.JokesItem;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final JokesRepository repository;
    private final MutableLiveData<List<JokesItem>> jokes = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    void init() {
        searchJokes("chuck");
    }
    @Inject
    public MainViewModel(JokesRepository repository) {
        this.repository = repository;
        this.init();
    }
    public LiveData<List<JokesItem>> getJokes() {
        return jokes;
    }
    public LiveData<Boolean> getLoadingState() {
        return isLoading;
    }
    public void searchJokes(String query) {
        isLoading.setValue(true);
        repository.searchJokes(query, new JokesRepository.ChuckNorrisCallback() {
            @Override
            public void onSuccess(Jokes response) {
                isLoading.setValue(false);
                jokes.setValue(response.getResult());
            }
            @Override
            public void onError(String errorMessage) {
                isLoading.setValue(false);
            }
        });
    }
}