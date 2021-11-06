package com.secure.isro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.secure.isro.R;
import com.secure.isro.viewModels.MainViewModel;

public class LaunchersFragements extends Fragment {

    MainViewModel mainViewModel;
    public LaunchersFragements(MainViewModel mainViewModel){
        this.mainViewModel = mainViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.launchers_fragement, null);
        return v;
    }
}
