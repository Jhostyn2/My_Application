package com.example.myapplication.ui.map.model;

public class LocationModel {
    private long id;
    private double latitude;
    private double longitude;

    public LocationModel(long id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
