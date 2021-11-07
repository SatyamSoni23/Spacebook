package com.secure.isro.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "spacecrafts")
public class SpacecraftsItem{

	@PrimaryKey(autoGenerate = true)
	private int spacecraftsId;

	private String name;
	private int id;

	public SpacecraftsItem(int spacecraftsId, String name, int id){
		this.spacecraftsId = spacecraftsId;
		this.name = name;
		this.id = id;
	}

	public int getSpacecraftsId() {
		return spacecraftsId;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}
