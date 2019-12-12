package com.example.retrofitmvvmlivedata.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofitmvvmlivedata.model.PostResponse;
import com.example.retrofitmvvmlivedata.network.PostFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<PostResponse>> currentPosts = new MutableLiveData<>();
    private PostFactory postFactory;

    public MainViewModel(@NonNull Application application) {
        super(application);
        postFactory = new PostFactory();
    }



    public LiveData<List<PostResponse>> getPosts(){

        postFactory.getPosts().enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
                currentPosts.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {

            }
        });

        return currentPosts;
    }
}
