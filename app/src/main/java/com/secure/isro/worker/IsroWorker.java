package com.secure.isro.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.secure.isro.IsroApplication;
import com.secure.isro.repository.IsroRepository;

public class IsroWorker extends Worker {

    public IsroWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        IsroRepository repository = ((IsroApplication)getApplicationContext()).isroRepository;
        repository.getIsroDataInBackground();
        return Result.success();
    }
}
