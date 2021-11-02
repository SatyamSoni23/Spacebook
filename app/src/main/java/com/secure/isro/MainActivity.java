package com.secure.isro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.secure.isro.models.Spacecrafts;
import com.secure.isro.repository.IsroRepository;
import com.secure.isro.viewModels.MainViewModel;
import com.secure.isro.viewModels.MainViewModelFactory;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IsroRepository repository =((IsroApplication)getApplicationContext()).isroRepository;
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(repository)).get(MainViewModel.class);
        mainViewModel.getSpacecrafts().observe(this, new Observer<Spacecrafts>() {
            @Override
            public void onChanged(Spacecrafts spacecrafts) {
                Log.d("TEST", String.valueOf(spacecrafts.getSpacecrafts().size()));
            }
        });
    }
}