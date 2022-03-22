package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.retrofitexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bd;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bd = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(bd.getRoot());

        initViewModel();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        initModelView();

        viewModel.getLoginRequest().observe(this, new Observer<LoginRequest>() {
            @Override
            public void onChanged(LoginRequest loginRequest) {
                Result result = loginRequest.getResult();
                String resultStr = result.getErrNo() + "  " + result.getErrMsg();

                if (!result.getErrNo().equals("0"))
                    bd.detileTV.setText(resultStr + "\n With Email: " + loginRequest.getData().getEmail());
                else
                    bd.detileTV.setText(resultStr);
            }
        });
    }

    private void initModelView() {

        bd.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = bd.phoneED.getText().toString();
                String password = bd.passwordED.getText().toString();
                viewModel.login(phone, password);
            }
        });
        initEvent();
    }

    private void initEvent() {

    }
}