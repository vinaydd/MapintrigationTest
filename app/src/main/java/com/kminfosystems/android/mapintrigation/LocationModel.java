package com.kminfosystems.android.mapintrigation;

import java.io.Serializable;

/**
 * Created by root on 9/3/16.
 */
public class LocationModel  implements Serializable {
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    private Double latitude;
    private Double longitude;


}
