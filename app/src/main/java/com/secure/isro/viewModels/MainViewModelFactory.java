package com.secure.isro.viewModels;

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
        if(modelClass.isAssignableFrom(MainViewModel.class))
            return (T) new MainViewModel(repository);
        throw new IllegalArgumentException("Unknown class name");
    }
}
