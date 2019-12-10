package com.example.retrofitmvvmlivedata.network;

import com.example.retrofitmvvmlivedata.model.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostFactory {
    private PostService postService;

    public  PostFactory(){
        postService = createService(createRetrofitInstance());
    }

    private Retrofit createRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private PostService createService(Retrofit retrofit){
        return retrofit.create(PostService.class);
    }

    public Call<List<PostResponse>> getPosts(){
        return postService.getPostResponseList();
    }
}
