package com.yair.pickachu.Entities;

/**
 * Created by Yair on 16/01/2020.
 */

import android.location.Location;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "parcels_table")
public class Parcel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private Enums.ParcelStatus parcelStatus;
    private Enums.ParcelType parcelType;
    private Enums.ParcelWeight parcelWeight;
    private Location location;

    private Date shippingDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enums.ParcelStatus getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(Enums.ParcelStatus parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public Enums.ParcelType getParcelType() {
        return parcelType;
    }

    public void setParcelType(Enums.ParcelType parcelType) {
        this.parcelType = parcelType;
    }

    public Enums.ParcelWeight getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(Enums.ParcelWeight parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }
}
