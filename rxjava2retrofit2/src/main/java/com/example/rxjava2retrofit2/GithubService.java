package com.example.rxjava2retrofit2;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



/**
 * Created by weijunhao on 2017/4/18.
 */

public interface GithubService {

    //只使用retrofit
    @GET("users/{user}/following")
    Call<List<User>> getUserFollowing(@Path("user") String user);

    //使用rxjava2 + retrofit2
    @GET("users/{user}/following")
    Observable<List<User>> getUserFollowingObservable(@Path("user") String user);

}
