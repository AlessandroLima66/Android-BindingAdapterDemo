package com.andersonbadari.bindingadapterdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.andersonbadari.bindingadapterdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // instancia o banco de dados
        MainActivityDatabase database = new MainActivityDatabaseImpl();

        // instancia o viewModel
        viewModel = new MainActivityViewModel(database);

        // vincula a view ao viewModel
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel); // vincula o viewModel
        binding.executePendingBindings();

    }

    // clique do botão do viewModel
    public void onButtonClick(View view){

        // assim
        /*MainActivityViewModel viewModel = binding.getViewModel();
        viewModel.showImage();*/

        // ou assim
        viewModel.showImage();
    }
}
