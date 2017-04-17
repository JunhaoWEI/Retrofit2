package com.example.weijunhao.retrofit2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by weijunhao on 2017/4/17.
 */

public interface GithubService {

    @GET
    Call<Endpoints> getAllEndpoints(@Url String url);

    @GET("users/{user}")
    Call<user> getUser(@Path("user") String user);
}
