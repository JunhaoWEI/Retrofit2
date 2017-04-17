package com.example.rxjava2retrofit2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import org.reactivestreams.Subscriber;

import java.util.List;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubService service = ServiceGenerator.createService(GithubService.class);
        Call<List<User>> userFollowing = service.getUserFollowing("junhaowei");
        userFollowing.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.i("wjh", response.body().toString());
                Log.i("wjh-url", response.toString());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });


        service.getUserFollowingObservable("junhaowei")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               // .subscribe(new Subscriber<List<User>>() {})

    }
}
