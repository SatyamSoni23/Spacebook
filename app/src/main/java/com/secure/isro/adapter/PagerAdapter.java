package com.secure.isro.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.secure.isro.fragments.CentresFragments;
import com.secure.isro.fragments.LaunchersFragements;
import com.secure.isro.fragments.SpacecraftsFragments;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabCount;
    public PagerAdapter(@NonNull FragmentManager fm, int behaviour) {
        super(fm, behaviour);
        tabCount = behaviour;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SpacecraftsFragments();
            case 1:
                return new LaunchersFragements();
            case 2:
                return new CentresFragments();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
