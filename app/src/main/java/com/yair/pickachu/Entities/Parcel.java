package com.yair.pickachu.Entities;

/**
 * Created by Yair on 16/01/2020.
 */

import android.location.Location;

import com.google.firebase.database.Exclude;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.room.Entity;
import androidx.room.Ignore;
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

    public Parcel() {
        location = new Location("");
        shippingDate = new Date();
    }

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

    @Exclude
    public Location getLocation() {
        return location;
    }

    @Exclude
    public void setLocation(Location location) {
        this.location = location;
    }

    @Ignore
    public void setLatitude(Double latitude){
        location.setLatitude(latitude);
    }

    @Ignore
    public void setLongitude(Double longitude){
        location.setLongitude(longitude);
    }
    @Ignore
    public Double getLatitude(){
        return location.getLatitude();
    }
    @Ignore
    public Double getLongitude(){
        return location.getLongitude();
    }

    @Exclude
    public Date getShippingDate() {
        return shippingDate;
    }

    @Exclude
    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getFBShippingDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(shippingDate);
    }


    public void setShippingDate(String shippingDate) {
        try {
            this.shippingDate = new SimpleDateFormat("dd/MM/yyyy").parse(shippingDate);
        }
        catch (Exception e){
            this.shippingDate = new Date();
        }
    }

}
