package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

public class LoginPostBody {

    @SerializedName("user_phone")
    private String phone;
    @SerializedName("login_password")
    private String password;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
