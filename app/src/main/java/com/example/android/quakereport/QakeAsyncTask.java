package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.widget.ProgressBar;


import java.util.ArrayList;

public class QakeAsyncTask extends AsyncTaskLoader<ArrayList<EarthquakeInfo>> {

    private  final String LOG_TAG = QakeAsyncTask.class.getName();
    private String urls;

    public QakeAsyncTask(Context context, String url) {
        super(context);
        this.urls = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<EarthquakeInfo> loadInBackground() {
        if(this.urls == null)
            return null;

        ArrayList<EarthquakeInfo> earthquakeInfo = Utils.fetchEarthquakeData(this.urls);
        return earthquakeInfo;
    }

}