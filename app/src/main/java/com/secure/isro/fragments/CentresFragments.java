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

public class CentresFragments extends Fragment {

    MainViewModel mainViewModel;
    public CentresFragments(MainViewModel mainViewModel){
        this.mainViewModel = mainViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.centres_fragememt, null);
        return v;
    }
}
