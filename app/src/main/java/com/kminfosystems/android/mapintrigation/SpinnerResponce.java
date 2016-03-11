package com.kminfosystems.android.mapintrigation;

import java.io.Serializable;

/**
 * Created by ios4_dev on 11/19/15.
 */
public class SpinnerResponce implements Serializable{
    private int id;
    private String name;
    private FromcentralModel fromcentral;
    private LocationModel location;
    public FromcentralModel getFromcentral() {
        return fromcentral;
    }
    public void setFromcentral(FromcentralModel fromcentral) {
        this.fromcentral = fromcentral;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}


