package com.andersonbadari.bindingadapterdemo.login;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;

/**
 * Created by Anderson Badari on 11/01/2018.
 */
public class LoginViewModel {

    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
    public ObservableBoolean loadingState = new ObservableBoolean();
    public ObservableBoolean isLoginDone = new ObservableBoolean();
    // adicionar validação em tempo real

    public void onLoginClick(){

        String mEmail = email.get();
        String mPassword = password.get();

        if (mEmail.equals("") || mPassword.equals("")){
            return;
        }

        // inicia o loading
        loadingState.set(true);

        // simula um delay de 1,5 segundo
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingState.set(false);
                isLoginDone.set(true);
            }
        },1500);


    }

}