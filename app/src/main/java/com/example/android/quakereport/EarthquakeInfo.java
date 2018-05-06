package com.example.android.quakereport;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dima on 3/17/17.
 */

public class EarthquakeInfo  {

    private String quakeScale;
    private String cityName;
    private String quakeDate;
    private String quakeURL;

    public EarthquakeInfo(String quakeScale, String cityName, String quakeDate, String quakeURL){
        this.quakeScale = quakeScale;
        this.cityName = cityName;
        this.quakeDate = quakeDate;
        this.quakeURL = quakeURL;
    }

    public String getQuakeScale(){
        return this.quakeScale;
    }
    public String getCityName(){
        return this.cityName;
    }
    public String getQuakeDate(){
        return this.quakeDate;
    }
    public String getQuakeURL(){
        return this.quakeURL;
    }

}
