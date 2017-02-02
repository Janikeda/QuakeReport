package com.example.android.quakereport;

/**
 * Created by Admin on 29.01.2017.
 */

public class Earthquake {

    private double mMagnitude;

    private String mNameCity;

    private long mDate;

    private String mUrl;

    public Earthquake (double mag, String city, long date, String url) {
        mMagnitude = mag;
        mNameCity = city;
        mDate = date;
        mUrl = url;

    }

    public double getMagnitude () {
        return mMagnitude;
    }

    public String getNameCity () {
        return mNameCity;
    }

    public long getDate () {
        return mDate;
    }

    public String getUrl () {
        return mUrl;
    }

}
