package com.yair.pickachu.Model;

import android.content.Context;

import com.yair.pickachu.Entities.Converters;
import com.yair.pickachu.Entities.Parcel;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * Created by Yair on 20/01/2020.
 */

@Database(entities = {Parcel.class}, version = 2)
@TypeConverters({Converters.class})
public abstract  class ParcelsDatabase extends RoomDatabase {

    public abstract ParcelsDao parcelsDao();

    private static ParcelsDatabase instance;

    public static synchronized ParcelsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ParcelsDatabase.class, "parcels_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

