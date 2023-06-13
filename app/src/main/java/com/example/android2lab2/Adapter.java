package com.example.android2lab2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MovieViewHolder> {
    private List<Movie> list;

    public void setList(List<Movie> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView genre;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tTextView);
            genre = itemView.findViewById(R.id.gTextView);
        }
    }
}
