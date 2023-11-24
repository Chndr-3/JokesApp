package com.sentuh.jokesapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sentuh.jokesapp.databinding.JokesItemBinding;
import com.sentuh.jokesapp.model.JokesItem;
import java.util.ArrayList;
import java.util.List;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.ViewHolder> {
    private List<JokesItem> jokesList;
    public JokesAdapter() {
        this.jokesList = new ArrayList<>(); // Initialize with null
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        JokesItemBinding binding = JokesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (jokesList != null) {
            JokesItem joke = jokesList.get(position);
            holder.binding.jokesText.setText(joke.getValue());
        }
    }
    @Override
    public int getItemCount() {
        return jokesList != null ? jokesList.size() : 0;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void submitList(List<JokesItem> newList) {
        jokesList = newList;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        JokesItemBinding binding;
        public ViewHolder(@NonNull JokesItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}