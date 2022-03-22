package com.example.retrofitexample;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

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
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://mapp.yemensoft.net/UltimateStore/api/")
                .build();
        api = retrofit.create(JsonPlaceHolderApi.class);

        loginRequest = new MutableLiveData<>();
    }

    public void login(String phone, String password) {
        Call<LoginRequest> call = api.login(phone, password);
        call.enqueue(new Callback<LoginRequest>() {
            @Override
            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
                Log.d(TAG, "onResponse: " + response.code());

                if (!response.isSuccessful()) {
                    return;
                }

                loginRequest.postValue(response.body());
            }

            @Override
            public void onFailure(Call<LoginRequest> call, Throwable t) {
                Log.e(TAG, "onResponse: " + t.getMessage());
            }
        });
    }
}
