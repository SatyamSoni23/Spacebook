package com.secure.isro.models;

public class IsroModels {

    private Spacecrafts spacecrafts;
    private Launchers launchers;
    private Centres centres;

    public IsroModels(Spacecrafts spacecrafts, Launchers launchers, Centres centres){
        this.spacecrafts = spacecrafts;
        this.launchers = launchers;
        this.centres = centres;
    }

    public Spacecrafts getSpacecrafts() {
        return spacecrafts;
    }

    public Launchers getLaunchers() {
        return launchers;
    }


    public Centres getCentres() {
        return centres;
    }
}
