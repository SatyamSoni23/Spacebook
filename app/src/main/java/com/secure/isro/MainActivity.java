package com.secure.isro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.secure.isro.adapter.PagerAdapter;
import com.secure.isro.databinding.ActivityMainBinding;
import com.secure.isro.models.Centres;
import com.secure.isro.models.Launchers;
import com.secure.isro.models.Spacecrafts;
import com.secure.isro.repository.IsroRepository;
import com.secure.isro.viewModels.MainViewModel;
import com.secure.isro.viewModels.MainViewModelFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel mainViewModel;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
        binding.fragmentContainer.setAdapter(pagerAdapter);

        Log.d("TEST", "OK 1");
        IsroRepository repository =((IsroApplication)getApplicationContext()).isroRepository;
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(repository)).get(MainViewModel.class);

        mainViewModel.getSpacecrafts().observe(this, new Observer<Spacecrafts>() {
            @Override
            public void onChanged(Spacecrafts spacecrafts) {
                Log.d("TEST", "OK 11.1 " + String.valueOf(spacecrafts.getSpacecrafts().size()));

            }
        });

        mainViewModel.getLaunchers().observe(this, new Observer<Launchers>() {
            @Override
            public void onChanged(Launchers launchers) {
                Log.d("TEST", "OK 11.2 " + String.valueOf(launchers.getLaunchers().size()));

            }
        });

        mainViewModel.getCentres().observe(this, new Observer<Centres>() {
            @Override
            public void onChanged(Centres centres) {
                Log.d("TEST", "OK 11.4 " + String.valueOf(centres.getCentres().size()));
            }
        });

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.fragmentContainer.setCurrentItem(tab.getPosition());
                if(tab.getPosition() >= 0 && tab.getPosition() < 3){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}