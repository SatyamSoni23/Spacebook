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
import com.secure.isro.adapter.LaunchersAdapter;
import com.secure.isro.databinding.LaunchersFragementBinding;
import com.secure.isro.models.Launchers;
import com.secure.isro.viewModels.MainViewModel;

public class LaunchersFragements extends Fragment {

    MainViewModel mainViewModel;
    MainActivity mainActivity;
    LaunchersAdapter launchersAdapter;
    LaunchersFragementBinding binding;

    public LaunchersFragements(MainViewModel mainViewModel, MainActivity mainActivity){
        this.mainViewModel = mainViewModel;
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.launchers_fragement, container, false);
        View view = binding.getRoot();
        binding.setLifecycleOwner(this);
        mainViewModel.getLaunchers().observe(mainActivity, new Observer<Launchers>() {
            @Override
            public void onChanged(Launchers launchers) {
                binding.launchersRecyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
                launchersAdapter = new LaunchersAdapter(launchers.getLaunchers());
                binding.launchersRecyclerView.setAdapter(launchersAdapter);
            }
        });
        return view;
    }
}
