package com.yair.pickachu.Entities;

import android.location.Location;

import androidx.room.TypeConverter;

/**
 * Created by Yair on 20/01/2020.
 */
public class Converters {
    @TypeConverter
    public static Location stringToLocation(String fromRoom) {
        if (fromRoom != "") {
            String[] latlong = fromRoom.split(",");
            double latitude = Double.parseDouble(latlong[0]);
            double longitude = Double.parseDouble(latlong[1]);
            Location location = new Location("");
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            return location;
        }
        return null;
    }


    @TypeConverter
    public static String locationToString(Location location) {
        if (location!= null){
            return Location.convert(location.getLatitude(), Location.FORMAT_DEGREES) + "," + Location.convert(location.getLongitude(), Location.FORMAT_DEGREES);
        }
        return "";
    }

    @TypeConverter
    public static Enums.ParcelType getType(Integer numeral){
        for(Enums.ParcelType ds : Enums.ParcelType.values()){
            if(ds.ordinal() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static int TypeToInetger(Enums.ParcelType parcelType) {
        return parcelType.ordinal();
    }

    @TypeConverter
    public static Enums.ParcelStatus getStatus(Integer numeral){
        for(Enums.ParcelStatus ds : Enums.ParcelStatus.values()){
            if(ds.ordinal() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static int StatusToInetger(Enums.ParcelStatus status) {
        return status.ordinal();
    }



}
