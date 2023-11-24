package com.sentuh.jokesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import com.sentuh.jokesapp.databinding.ActivityMainBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;
    private JokesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com.sentuh.jokesapp.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        adapter = new JokesAdapter();
        RecyclerView recyclerView = binding.jokesRv;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel.getJokes().observe(this, jokesItem -> {
            adapter.submitList(jokesItem);
            if(jokesItem.size() == 0){
                binding.noJokesMessage.setText(String.format("We cant find any '%s' jokes", binding.searchEditText.getText()));
                binding.noJokesMessage.setVisibility(View.VISIBLE);
            } else{
                binding.noJokesMessage.setVisibility(View.INVISIBLE);
            }
        });
        viewModel.getLoadingState().observe(this, loadingState ->{
            binding.loadingProgressBar.setVisibility(loadingState ? View.VISIBLE : View.GONE);
            binding.jokesRv.setVisibility(loadingState ? View.INVISIBLE : View.VISIBLE);
        });
        binding.cariButton.setOnClickListener(v -> {
            String query = binding.searchEditText.getText().toString().trim();
            if(query.isEmpty()){
                viewModel.init();
            }else {
                viewModel.searchJokes(query);
            }
        });
    }
}