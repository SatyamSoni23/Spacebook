package com.secure.isro.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Centres{
	@SerializedName("centres")
	private List<CentresItem> centres;

	public Centres(List<CentresItem> centres){
		this.centres = centres;
	}

	public List<CentresItem> getCentres(){
		return centres;
	}
}