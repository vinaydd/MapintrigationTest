package com.kminfosystems.android.mapintrigation;

import java.io.Serializable;

/**
 * Created by root on 9/3/16.
 */
public class FromcentralModel implements Serializable{
    private String car;
    private String train;
    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }


}
