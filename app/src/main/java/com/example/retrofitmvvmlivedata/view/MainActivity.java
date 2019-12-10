package com.example.retrofitmvvmlivedata.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvvmlivedata.R;
import com.example.retrofitmvvmlivedata.adapter.PostAdapter;
import com.example.retrofitmvvmlivedata.model.PostResponse;
import com.example.retrofitmvvmlivedata.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.display_posts);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getPosts().observe(this, new Observer<List<PostResponse>>() {
            @Override
            public void onChanged(List<PostResponse> postResponses) {
                recyclerView.setAdapter(new PostAdapter(postResponses));
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
