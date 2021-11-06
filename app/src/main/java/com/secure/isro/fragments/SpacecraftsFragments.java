package com.secure.isro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.secure.isro.MainActivity;
import com.secure.isro.R;
import com.secure.isro.adapter.SpacecraftsAdapter;
import com.secure.isro.databinding.SpacecraftsFragementBinding;
import com.secure.isro.models.Spacecrafts;
import com.secure.isro.viewModels.MainViewModel;

public class SpacecraftsFragments extends Fragment {

    MainViewModel mainViewModel;
    SpacecraftsAdapter spacecraftsAdapter;
    MainActivity mainActivity;
    SpacecraftsFragementBinding binding;

    public SpacecraftsFragments(MainViewModel mainViewModel, MainActivity mainActivity){
        this.mainViewModel = mainViewModel;
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.spacecrafts_fragement, container, false);
        View view = binding.getRoot();
        binding.setLifecycleOwner(this);
        mainViewModel.getSpacecrafts().observe(mainActivity, new Observer<Spacecrafts>() {
            @Override
            public void onChanged(Spacecrafts spacecrafts) {
                binding.spacecraftsRecyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
                spacecraftsAdapter = new SpacecraftsAdapter(spacecrafts.getSpacecrafts());
                binding.spacecraftsRecyclerView.setAdapter(spacecraftsAdapter);
            }
        });
        return view;

    }
}
