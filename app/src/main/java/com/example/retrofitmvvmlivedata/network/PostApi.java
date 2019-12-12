package com.example.retrofitmvvmlivedata.network;

import com.example.retrofitmvvmlivedata.model.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("posts/")
    Call<List<PostResponse>> getPostResponseList();

}
