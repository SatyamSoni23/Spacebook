package com.secure.isro.models;

import com.google.gson.annotations.SerializedName;

public class CentresItem{
	@SerializedName("id")
	private int id;
	@SerializedName("name")
	private String name;
	@SerializedName("Place")
	private String place;
	@SerializedName("State")
	private String state;

	public String getState(){
		return state;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getPlace(){
		return place;
	}
}
