package com.secure.isro.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.secure.isro.db.IsroDatabase;
import com.secure.isro.models.CentresItem;
import com.secure.isro.models.LaunchersItem;
import com.secure.isro.models.SpacecraftsItem;
import com.secure.isro.networkUtils.NetworkUtils;
import com.secure.isro.api.IsroService;
import com.secure.isro.models.Centres;
import com.secure.isro.models.Launchers;
import com.secure.isro.models.Spacecrafts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IsroRepository {

    private IsroService isroService;
    private Context applicationContext;
    private IsroDatabase isroDatabase;

    MutableLiveData<Spacecrafts> spacecraftsLiveData = new MutableLiveData<>();
    MutableLiveData<Launchers> launchersLiveData = new MutableLiveData<>();
    MutableLiveData<Centres> centresLiveData = new MutableLiveData<>();

    public IsroRepository(IsroService isroService, IsroDatabase isroDatabase, Context applicationContext){
        this.isroService = isroService;
        this.applicationContext = applicationContext;
        this.isroDatabase = isroDatabase;
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

    public LiveData<Centres> centres = getCentres();
    private LiveData<Centres> getCentres() {
        return centresLiveData;
    }

    public void getIsroData(){
        if(NetworkUtils.isNetworkAvailable(applicationContext)){
            CallApi(isroService.getSpacecraft(), "Spacecrafts");
            CallApi(isroService.getLaunchers(), "Launchers");
            CallApi(isroService.getCentres(), "Centres");
            Log.d("TEST", "OK 7");
        }
        else{
            startOfflineMode();
            Log.d("TEST", "YOU ARE OFFLINE");
        }
    }

    private <T> void CallApi(Call<T> result, String type) {
        result.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response != null && response.body() != null){
                    Log.d("TEST", "OK 8 " + type);
                    switch (type){
                        case "Spacecrafts":
                            Log.d("TEST", "OK 8.1");
                            spacecraftsLiveData.postValue((Spacecrafts) response.body());
                            insertSpacecrafts((Response<Spacecrafts>) response);
                            break;
                        case "Launchers":
                            Log.d("TEST", "OK 8.2");
                            launchersLiveData.postValue((Launchers) response.body());
                            insertLaunchers((Response<Launchers>) response);
                            break;
                        case "Centres":
                            Log.d("TEST", "OK 8.4");
                            centresLiveData.postValue((Centres) response.body());
                            insertCentres((Response<Centres>) response);
                            break;
                    }
                }
                else{
                    Log.d("TEST", "OK " + type + " = NULL");
                }
            }
            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d("TEST", t.getMessage());
            }
        });
    }

    private void insertSpacecrafts(Response<Spacecrafts> response){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                isroDatabase.isroDao().addSpacecrafts(response.body().getSpacecrafts());
            }
        });
    }
    private void insertLaunchers(Response<Launchers> response){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                isroDatabase.isroDao().addLaunchers(response.body().getLaunchers());
            }
        });
    }
    private void insertCentres(Response<Centres> response){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                isroDatabase.isroDao().addCentres(response.body().getCentres());
            }
        });
    }

    private void startOfflineMode() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                List<SpacecraftsItem> spacecraftsItemList = isroDatabase.isroDao().getSpacecrafts();
                Spacecrafts spacecrafts = new Spacecrafts(spacecraftsItemList);
                spacecraftsLiveData.postValue(spacecrafts);

                List<LaunchersItem> launchersItemList = isroDatabase.isroDao().getLaunchers();
                Launchers launchers = new Launchers(launchersItemList);
                launchersLiveData.postValue(launchers);

                List<CentresItem> centresItemList = isroDatabase.isroDao().getCentres();
                Centres centres = new Centres(centresItemList);
                centresLiveData.postValue(centres);
            }
        });
    }

    public void getIsroDataInBackground(){
        CallApi(isroService.getSpacecraft(), "Spacecrafts");
        CallApi(isroService.getLaunchers(), "Launchers");
        CallApi(isroService.getCentres(), "Centres");
    }
}
