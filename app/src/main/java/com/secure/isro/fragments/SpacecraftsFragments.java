package com.secure.isro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.secure.isro.MainActivity;
import com.secure.isro.R;
import com.secure.isro.adapter.SpacecraftsAdapter;
import com.secure.isro.models.Spacecrafts;
import com.secure.isro.viewModels.MainViewModel;

public class SpacecraftsFragments extends Fragment {

    MainViewModel mainViewModel;
    SpacecraftsAdapter spacecraftsAdapter;
    MainActivity mainActivity;
    RecyclerView recyclerView;

    public SpacecraftsFragments(MainViewModel mainViewModel, MainActivity mainActivity){
        this.mainViewModel = mainViewModel;
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.spacecrafts_fragement, null);
        recyclerView = v.findViewById(R.id.spacecraftsRecyclerView);

        mainViewModel.getSpacecrafts().observe(mainActivity, new Observer<Spacecrafts>() {
            @Override
            public void onChanged(Spacecrafts spacecrafts) {
                recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
                spacecraftsAdapter = new SpacecraftsAdapter(spacecrafts.getSpacecrafts());
                recyclerView.setAdapter(spacecraftsAdapter);
            }
        });
        return v;
    }
}
