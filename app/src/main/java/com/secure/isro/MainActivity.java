package com.secure.isro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.secure.isro.models.CustomerSatellites;
import com.secure.isro.repository.IsroRepository;
import com.secure.isro.viewModels.MainViewModel;
import com.secure.isro.viewModels.MainViewModelFactory;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TEST", "OK 1");
        IsroRepository repository =((IsroApplication)getApplicationContext()).isroRepository;
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(repository)).get(MainViewModel.class);
//        mainViewModel.getSpacecrafts().observe(this, new Observer<Spacecrafts>() {
//            @Override
//            public void onChanged(Spacecrafts spacecrafts) {
//                Log.d("TEST", "OK 11.1 " + String.valueOf(spacecrafts.getSpacecrafts().size()));
//            }
//        });
//        mainViewModel.getLaunchers().observe(this, new Observer<Launchers>() {
//            @Override
//            public void onChanged(Launchers launchers) {
//                Log.d("TEST", "OK 11.2 " + String.valueOf(launchers.getLaunchers().size()));
//            }
//        });
        mainViewModel.getCustomerSatellites().observe(this, new Observer<CustomerSatellites>() {
            @Override
            public void onChanged(CustomerSatellites customerSatellites) {
                if(customerSatellites.getCustomerSatellites() == null){
                    Log.d("TEST", "OK BUT NULL");
                    return;
                }
                Log.d("TEST", "OK 11.3");
            }
        });
//        mainViewModel.getCentres().observe(this, new Observer<Centres>() {
//            @Override
//            public void onChanged(Centres centres) {
//                Log.d("TEST", "OK 11.4 " + String.valueOf(centres.getCentres().size()));
//            }
//        });
    }
}