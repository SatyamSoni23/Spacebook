package com.secure.isro.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.secure.isro.models.Centres;
import com.secure.isro.models.CustomerSatellites;
import com.secure.isro.models.Launchers;
import com.secure.isro.models.Spacecrafts;
import com.secure.isro.repository.IsroRepository;

public class MainViewModel extends ViewModel {
    private IsroRepository isroRepository;
    public MainViewModel(IsroRepository isroRepository){
        this.isroRepository = isroRepository;
        this.isroRepository.getIsroData();
    }
    public LiveData<Spacecrafts> getSpacecrafts(){
        return isroRepository.spacecrafts;
    }
    public LiveData<Launchers> getLaunchers(){
        return isroRepository.launchers;
    }
    public LiveData<CustomerSatellites> getCustomerSatellites(){
        return isroRepository.customerSatellites;
    }
    public LiveData<Centres> getCentres(){
        return isroRepository.centres;
    }
}
