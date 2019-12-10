package com.example.retrofitmvvmlivedata.network;

import androidx.lifecycle.LiveData;

import com.example.retrofitmvvmlivedata.model.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("posts/")
    Call<List<PostResponse>> getPostResponseList();

}
