package com.secure.isro;

import android.app.Application;
import android.util.Log;

import com.secure.isro.api.IsroService;
import com.secure.isro.api.RetrofitHelper;
import com.secure.isro.repository.IsroRepository;

public class IsroApplication extends Application {
    public IsroRepository isroRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        IsroService isroService = RetrofitHelper.getInstances().create(IsroService.class);
        isroRepository = new IsroRepository(isroService, getApplicationContext());
    }
}
