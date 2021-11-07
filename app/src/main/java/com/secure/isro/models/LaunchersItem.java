package com.secure.isro.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "launchers")
public class LaunchersItem{

	@PrimaryKey(autoGenerate = true)
	private int launchersId;

	private String id;

	public int getLaunchersId() {
		return launchersId;
	}

	public LaunchersItem(int launchersId, String id){
		this.launchersId = launchersId;
		this.id = id;
	}

	public String getId(){
		return id;
	}
}
