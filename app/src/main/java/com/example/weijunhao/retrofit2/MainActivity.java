package com.example.weijunhao.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubService githubService = ServiceGenerator.createService(GithubService.class);
        Call<Endpoints> endpointsCall = githubService.getAllEndpoints("");
        endpointsCall.enqueue(new Callback<Endpoints>() {
            @Override
            public void onResponse(Call<Endpoints> call, Response<Endpoints> response) {
                Endpoints endpoints = response.body();
                Log.i("wjh", endpoints.toString());
                Log.i("wjh-url", response.toString());
            }

            @Override
            public void onFailure(Call<Endpoints> call, Throwable t) {
                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });

        Call<user> userCall = githubService.getUser("junhaowei");
        userCall.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {
                Log.i("wjh",response.body().toString());
                Log.i("wjh-url",response.toString());
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {

            }
        });
    }


}
