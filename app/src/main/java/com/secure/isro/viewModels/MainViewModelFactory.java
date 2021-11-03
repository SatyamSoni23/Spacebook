package com.secure.isro.viewModels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.secure.isro.repository.IsroRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private IsroRepository repository;

    public MainViewModelFactory(IsroRepository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MainViewModel.class)) {
            Log.d("TEST", "OK 5");
            return (T) new MainViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
