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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);


//        ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
//
//        earthquakes.add(new Earthquake("7.2", "San Francisco", "Oct 2, 2016"));
//        earthquakes.add(new Earthquake("5.2",  "London", "March 22, 2015"));
//        earthquakes.add(new Earthquake("6.2", "Tokyo", "Dec 6, 2014"));
//        earthquakes.add(new Earthquake("4.2", "Mexico City", "June 22, 2013"));
//        earthquakes.add(new Earthquake("3.2", "Moscow", "May 3, 2016"));
//        earthquakes.add(new Earthquake("7.2", "Rio de Janeiro", "July 5, 2015"));
//        earthquakes.add(new Earthquake("1.2", "Paris", "Jan 5, 2012"));

        final ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter (this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface

        earthquakeListView.setAdapter(adapter);



        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Earthquake earth = earthquakes.get(position);
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,

                Uri.parse(earth.getUrl()));
                startActivity(i);
            }
        });
    }
}
