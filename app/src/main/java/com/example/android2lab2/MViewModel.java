package com.example.android2lab2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> list;

    public LiveData<List<Movie>> getMovies() {
        if (list == null) {
            list = new MutableLiveData<>();
            list.setValue(new ArrayList<>());
        }
        return list;
    }

    public void addMovie(String title, String genre) {
        Movie movie = new Movie(title, genre);
        List<Movie> movieList = list.getValue();
        if (movieList != null) {
            movieList.add(movie);
            list.setValue(movieList);
        }
    }
}
