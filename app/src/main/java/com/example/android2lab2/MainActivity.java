package com.example.android2lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private Button btn;
    private RecyclerView recyclerView;
    private Adapter adapter;

    private MViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonName2);
        btn = findViewById(R.id.Button);
        recyclerView = findViewById(R.id.recyclerView);

        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        mViewModel = new ViewModelProvider(
                this).get(MViewModel.class);

        mViewModel.getMovies().observe(
                this, new Observer<List<Movie>>() {
                    @Override
                    public void onChanged(List<Movie> movies) {
                        adapter.setList(movies);
                    }
                });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText1.getText().toString();
                String genre = editText2.getText().toString();
                mViewModel.addMovie(title, genre);
                editText1.setText("");
                editText2.setText("");
            }
        });
    }
}
