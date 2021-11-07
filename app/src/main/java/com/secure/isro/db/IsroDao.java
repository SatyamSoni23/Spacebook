package com.secure.isro.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.secure.isro.models.CentresItem;
import com.secure.isro.models.LaunchersItem;
import com.secure.isro.models.SpacecraftsItem;

import java.util.List;

@Dao
public interface IsroDao {

    @Insert
    void addSpacecrafts(List<SpacecraftsItem> spacecrafts);

    @Insert
    void addLaunchers(List<LaunchersItem> launchers);

    @Insert
    void addCentres(List<CentresItem> centres);

    @Query("SELECT * FROM spacecrafts")
    List<SpacecraftsItem> getSpacecrafts();

    @Query("SELECT * FROM launchers")
    List<LaunchersItem> getLaunchers();

    @Query("SELECT * FROM centres")
    List<CentresItem> getCentres();
}
