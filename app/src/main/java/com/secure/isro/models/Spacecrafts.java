package com.secure.isro.models;

import java.util.List;

public class Spacecrafts{
	private List<SpacecraftsItem> spacecrafts;

	public Spacecrafts(List<SpacecraftsItem> spacecrafts){
		this.spacecrafts = spacecrafts;
	}

	public List<SpacecraftsItem> getSpacecrafts(){
		return spacecrafts;
	}
}