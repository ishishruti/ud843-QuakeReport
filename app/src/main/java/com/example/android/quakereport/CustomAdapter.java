package com.example.android.quakereport;

/**
 * Created by shruti.shamdasani on 10/12/2016.
 */

public class CustomAdapter {

    private double mag;
    private String location;
    private int time;
    public CustomAdapter(double m, String l, int t){
        mag=m;
        location=l;
        time=t;
    };

    public double getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
