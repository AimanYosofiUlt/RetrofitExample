package com.example.retrofitexample;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepo {
    private static final String TAG = "UserRepo";
    Retrofit retrofit;
    JsonPlaceHolderApi api;
    MutableLiveData<LoginRequest> loginRequest;

    UserRepo() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://mapp.yemensoft.net/UltimateStore/api/")
                .client(client)
                .build();
        api = retrofit.create(JsonPlaceHolderApi.class);

        loginRequest = new MutableLiveData<>();
    }

    public void login(LoginPostBody loginPostBody) {

        Call<LoginRequest> call = api.login(loginPostBody);
        call.enqueue(new Callback<LoginRequest>() {
            @Override
            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse is Not Successful: " + response.code());
                    return;
                }
                Log.d(TAG, "onResponse isSuccessful: " + response.code());
                loginRequest.postValue(response.body());
            }

            @Override
            public void onFailure(Call<LoginRequest> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
