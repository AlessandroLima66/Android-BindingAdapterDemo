package com.andersonbadari.bindingadapterdemo.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andersonbadari.bindingadapterdemo.R;
import com.andersonbadari.bindingadapterdemo.databinding.ActivityLoginBinding;
import com.andersonbadari.bindingadapterdemo.main.MainActivity;

/**
 * Created by Anderson Badari on 11/01/2018.
 */
public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel loginViewModel;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // instancia o viewModel
        loginViewModel = new LoginViewModel();

        // vincula a view ao viewModel
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel(loginViewModel);
        binding.executePendingBindings();

        bindLoadingState();
    }

    public void onLoginClick(View view){
        binding.getViewModel().onLoginClick();
    }

    public void bindLoadingState() {

        binding.getViewModel().loadingState.addOnPropertyChangedCallback(
                new Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(Observable observable, int i) {
                        boolean isLoading = binding.getViewModel().loadingState.get();
                        if (isLoading){
                            progressDialog =
                                    ProgressDialog.show(LoginActivity.this,"Carregando",
                                            "Aguarde...",true, false);
                        } else {
                            progressDialog.dismiss();
                        }
                    }
                });

        binding.getViewModel().isLoginDone.addOnPropertyChangedCallback(
                new Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(Observable observable, int i) {
                        boolean isLoginDone = binding.getViewModel().isLoginDone.get();

                        if (isLoginDone){
                            startActivity(
                                    new Intent(
                                            LoginActivity.this, MainActivity.class));
                        }
                    }
                });

    }
}











