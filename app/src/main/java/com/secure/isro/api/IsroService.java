package com.secure.isro.api;

import com.secure.isro.models.Centres;
import com.secure.isro.models.CustomerSatellites;
import com.secure.isro.models.Launchers;
import com.secure.isro.models.Spacecrafts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IsroService {

    @GET("/spacecrafts")
    Call<Spacecrafts> getSpacecraft();

    @GET("/launchers")
    Call<Launchers> getLaunchers();

    @GET("/customer_satellites")
    Call<CustomerSatellites> getCustomerSatellites();

    @GET("/centres")
    Call<Centres> getCentres();
}
