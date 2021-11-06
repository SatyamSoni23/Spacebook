package com.secure.isro.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.secure.isro.MainActivity;
import com.secure.isro.fragments.CentresFragments;
import com.secure.isro.fragments.LaunchersFragements;
import com.secure.isro.fragments.SpacecraftsFragments;
import com.secure.isro.viewModels.MainViewModel;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabCount;
    MainViewModel mainViewModel;
    MainActivity mainActivity;
    public PagerAdapter(@NonNull FragmentManager fm, int behaviour, MainViewModel mainViewModel, MainActivity mainActivity) {
        super(fm, behaviour);
        tabCount = behaviour;
        this.mainViewModel = mainViewModel;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SpacecraftsFragments(mainViewModel, mainActivity);
            case 1:
                return new LaunchersFragements(mainViewModel);
            case 2:
                return new CentresFragments(mainViewModel);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
