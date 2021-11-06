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
import com.secure.isro.adapter.CentresAdapter;
import com.secure.isro.databinding.CentresFragememtBinding;
import com.secure.isro.models.Centres;
import com.secure.isro.viewModels.MainViewModel;

public class CentresFragments extends Fragment {

    MainViewModel mainViewModel;
    MainActivity mainActivity;
    CentresAdapter centresAdapter;
    CentresFragememtBinding binding;

    public CentresFragments(MainViewModel mainViewModel, MainActivity mainActivity){
        this.mainViewModel = mainViewModel;
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.centres_fragememt, container, false);
        View view = binding.getRoot();
        binding.setLifecycleOwner(this);
        mainViewModel.getCentres().observe(mainActivity, new Observer<Centres>() {
            @Override
            public void onChanged(Centres centres) {
                binding.centresRecyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
                centresAdapter = new CentresAdapter(centres.getCentres());
                binding.centresRecyclerView.setAdapter(centresAdapter);
            }
        });
        return view;
    }
}
