/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class
EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    public static final String URL_usgs = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        new EarthquakeAsync().execute(URL_usgs);
    }

    private class EarthquakeAsync extends AsyncTask<String,Void,ArrayList<CustomAdapter>>{
        @Override
        protected ArrayList<CustomAdapter> doInBackground(String... strings) {
            return QueryUtils.fetchEarthquakeData(strings[0]);
        }

        @Override
        protected void onPostExecute(ArrayList<CustomAdapter> customAdapters) {
            ListView earthquakeListView = (ListView) findViewById(R.id.list);
            CustomAdapterImplement adapter = new CustomAdapterImplement(EarthquakeActivity.this,customAdapters);
            earthquakeListView.setAdapter(adapter);
        }
    }
}
