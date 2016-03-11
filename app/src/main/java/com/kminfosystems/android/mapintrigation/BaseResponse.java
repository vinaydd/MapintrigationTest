package com.kminfosystems.android.mapintrigation;

import java.io.Serializable;

/**
 * Created by ios4_dev on 11/19/15.
 */
public class BaseResponse implements Serializable{
    private String message;
    private boolean error;

    private  SpinnerResponce [] data ;

    public SpinnerResponce[] getData() {
        return data;
    }

    public void setData(SpinnerResponce[] data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


