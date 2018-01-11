package com.andersonbadari.bindingadapterdemo.main;

import android.databinding.ObservableField;
import android.os.Handler;

/**
 * Created by Anderson Badari on 10/01/2018.
 */
public class MainActivityViewModel {

    public ObservableField<String> meuURL = new ObservableField<>();
    private MainActivityDatabase database;

    public MainActivityViewModel(MainActivityDatabase database) {
        // injeção de dependência
        this.database = database;
    }

    // simula uma chamada na api
    public void showImage() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String url = database.getUrl();
                meuURL.set(url);
            }
        }, 1500);

    }
}
