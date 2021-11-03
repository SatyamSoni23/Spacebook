package com.secure.isro.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.secure.isro.models.CustomerSatellites;
import com.secure.isro.networkUtils.NetworkUtils;
import com.secure.isro.api.IsroService;
import com.secure.isro.models.Centres;
import com.secure.isro.models.Launchers;
import com.secure.isro.models.Spacecrafts;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IsroRepository {

    private IsroService isroService;
    private Context applicationContext;

    MutableLiveData<Spacecrafts> spacecraftsLiveData = new MutableLiveData<>();
    MutableLiveData<Launchers> launchersLiveData = new MutableLiveData<>();
    MutableLiveData<CustomerSatellites> customerSatellitesLiveData = new MutableLiveData<>();
    MutableLiveData<Centres> centresLiveData = new MutableLiveData<>();

    public IsroRepository(IsroService isroService, Context applicationContext){
        this.isroService = isroService;
        this.applicationContext = applicationContext;
        Log.d("TEST", "OK 4");
    }

    public LiveData<Spacecrafts> spacecrafts = getSpacecrafts();
    private LiveData<Spacecrafts> getSpacecrafts() {
        return spacecraftsLiveData;
    }

    public LiveData<Launchers> launchers = getLaunchers();
    private LiveData<Launchers> getLaunchers() {
        return launchersLiveData;
    }

    public LiveData<CustomerSatellites> customerSatellites = getCustomerSatellites();
    private LiveData<CustomerSatellites> getCustomerSatellites() {
        Log.d("TEST", "OK 9");
        return customerSatellitesLiveData;
    }

    public LiveData<Centres> centres = getCentres();
    private LiveData<Centres> getCentres() {
        return centresLiveData;
    }

    public void getIsroData(){
        if(NetworkUtils.isNetworkAvailable(applicationContext)){
            //CallApi(isroService.getSpacecraft(), "Spacecrafts");
            //CallApi(isroService.getLaunchers(), "Launchers");
            CallApi(isroService.getCustomerSatellites(), "CustomerSatellites");
            //CallApi(isroService.getCentres(), "Centres");
            Log.d("TEST", "OK 7");
        }
        else{
            Log.d("TEST", "YOU ARE OFFLINE");
        }
    }

    private <T> void CallApi(Call<T> result, String type) {
        result.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response == null || response.body() == null){
                    Log.d("TEST", "OK " + type + " = NULL");
                    return;
                }
                Log.d("TEST", "OK 8 " + type);
                switch (type){
                    case "Spacecrafts":
                        Log.d("TEST", "OK 8.1");
                        spacecraftsLiveData.postValue((Spacecrafts) response.body());
                        break;
                    case "Launchers":
                        Log.d("TEST", "OK 8.2");
                        launchersLiveData.postValue((Launchers) response.body());
                        break;
                    case "CustomerSatellites":
                        customerSatellitesLiveData.postValue((CustomerSatellites) response.body());
                        Log.d("TEST", "OK 8.3");
                        break;
                    case "Centres":
                        Log.d("TEST", "OK 8.4");
                        centresLiveData.postValue((Centres) response.body());
                        break;
                }
            }
            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d("TEST", t.getMessage());
            }
        });
    }
}
