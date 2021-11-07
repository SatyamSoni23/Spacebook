package com.secure.isro.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "centres")
public class CentresItem{

	@PrimaryKey(autoGenerate = true)
	private int centresId;

	@SerializedName("id")
	private int id;
	@SerializedName("name")
	private String name;
	@SerializedName("Place")
	private String place;
	@SerializedName("State")
	private String state;

	public CentresItem(int centresId, int id, String name, String place, String state){
		this.centresId = centresId;
		this.id = id;
		this.name = name;
		this.place = place;
		this.state = state;
	}

	public int getCentresId() {
		return centresId;
	}

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
