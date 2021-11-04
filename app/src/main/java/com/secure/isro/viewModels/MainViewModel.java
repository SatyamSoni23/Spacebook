package com.secure.isro.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.secure.isro.models.Centres;
import com.secure.isro.models.Launchers;
import com.secure.isro.models.Spacecrafts;
import com.secure.isro.repository.IsroRepository;

public class MainViewModel extends ViewModel {
    private IsroRepository isroRepository;
    public MainViewModel(IsroRepository isroRepository){
        this.isroRepository = isroRepository;
        Log.d("TEST", "OK 6");
        this.isroRepository.getIsroData();
    }

    public LiveData<Spacecrafts> getSpacecrafts(){
        Log.d("TEST", "OK 10");
        return isroRepository.spacecrafts;
    }

    public LiveData<Launchers> getLaunchers(){
        return isroRepository.launchers;
    }

    public LiveData<Centres> getCentres(){
        return isroRepository.centres;
    }
}
