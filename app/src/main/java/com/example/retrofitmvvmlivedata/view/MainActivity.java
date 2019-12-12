package com.example.retrofitmvvmlivedata.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvvmlivedata.R;
import com.example.retrofitmvvmlivedata.adapter.PostAdapter;
import com.example.retrofitmvvmlivedata.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private TextView errorText;
    private PostAdapter postAdapter = new PostAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.display_posts);
        errorText = findViewById(R.id.error_display);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(mainViewModel.getPosts() != null) {
            mainViewModel.getPosts().observe(this, posts -> postAdapter.updateData(posts));
        } else {
            errorText.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }


    }
}
