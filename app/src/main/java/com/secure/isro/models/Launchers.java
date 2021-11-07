package com.secure.isro.models;

import java.util.List;

public class Launchers{
	private List<LaunchersItem> launchers;

	public Launchers(List<LaunchersItem> launchers){
		this.launchers = launchers;
	}

	public List<LaunchersItem> getLaunchers(){
		return launchers;
	}
}