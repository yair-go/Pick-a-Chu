package com.yair.pickachu.Model;

import com.yair.pickachu.Entities.Parcel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by Yair on 20/01/2020.
 */
@Dao
public interface ParcelsDao {
    @Insert
    long insert(Parcel parcel);

    @Update
    void update(Parcel parcel);

    @Delete
    void delete(Parcel parcel);

    @Query("SELECT * FROM parcels_table ORDER BY shippingDate DESC")
    LiveData<List<Parcel>> getAllParcels();
}
