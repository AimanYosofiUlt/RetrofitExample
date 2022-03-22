package com.example.retrofitexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityViewModel extends AndroidViewModel {
    UserRepo userRepo ;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepo = new UserRepo();
    }

}
