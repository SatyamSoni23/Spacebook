package com.secure.isro.models;

public class IsroModels {

    private Spacecrafts spacecrafts;
    private Launchers launchers;
    private CustomerSatellites customerSatellites;
    private Centres centres;

    public IsroModels(Spacecrafts spacecrafts, Launchers launchers, CustomerSatellites customerSatellites, Centres centres){
        this.spacecrafts = spacecrafts;
        this.launchers = launchers;
        this.customerSatellites = customerSatellites;
        this.centres = centres;
    }

    public Spacecrafts getSpacecrafts() {
        return spacecrafts;
    }

    public Launchers getLaunchers() {
        return launchers;
    }

    public CustomerSatellites getCustomerSatellites() {
        return customerSatellites;
    }

    public Centres getCentres() {
        return centres;
    }
}
