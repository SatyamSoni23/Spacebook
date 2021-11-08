package com.secure.isro;

import android.app.Application;
import android.util.Log;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.secure.isro.api.IsroService;
import com.secure.isro.api.RetrofitHelper;
import com.secure.isro.db.IsroDatabase;
import com.secure.isro.repository.IsroRepository;
import com.secure.isro.worker.IsroWorker;

import java.util.concurrent.TimeUnit;

public class IsroApplication extends Application {
    public IsroRepository isroRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
        setupWorker();
    }

    private void setupWorker() {
        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        PeriodicWorkRequest workRequest = new PeriodicWorkRequest.Builder(IsroWorker.class,30, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build();
        WorkManager.getInstance(this).enqueue(workRequest);
    }

    private void initialize() {
        Log.d("TEST", "OK 2");
        IsroService isroService = RetrofitHelper.getInstances().create(IsroService.class);
        IsroDatabase isroDatabase = IsroDatabase.getDatabase(getApplicationContext());
        isroRepository = new IsroRepository(isroService, isroDatabase, getApplicationContext());
    }
}
