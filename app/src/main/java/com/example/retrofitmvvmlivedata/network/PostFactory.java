package com.example.retrofitmvvmlivedata.network;

import com.example.retrofitmvvmlivedata.model.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostFactory {
    private PostApi postApi;

    public  PostFactory(){
        postApi = createService(createRetrofitInstance());
    }

    private Retrofit createRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private PostApi createService(Retrofit retrofit){
        return retrofit.create(PostApi.class);
    }

    public Call<List<PostResponse>> getPosts(){
        return postApi.getPostResponseList();
    }
}
