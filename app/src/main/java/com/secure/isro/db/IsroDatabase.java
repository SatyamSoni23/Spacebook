package com.secure.isro.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.secure.isro.models.CentresItem;
import com.secure.isro.models.LaunchersItem;
import com.secure.isro.models.SpacecraftsItem;

@Database(entities = {SpacecraftsItem.class, LaunchersItem.class, CentresItem.class}, version = 1)
public abstract class IsroDatabase extends RoomDatabase {

    private static final String DB_NAME = "IsroDB";
    private static volatile IsroDatabase instance;

    public static synchronized IsroDatabase getDatabase(Context context){
        if(instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static IsroDatabase create(final Context context){
        return Room.databaseBuilder(context, IsroDatabase.class, DB_NAME)
                .build();
    }

    public abstract IsroDao isroDao();
}