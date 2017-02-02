package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import static android.content.ContentValues.TAG;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    CharSequence cs1 = "of";



    public EarthquakeAdapter (Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Earthquake currentEarthquake = getItem(position);
        TextView magnitTextView = (TextView) listItemView.findViewById(R.id.magnit);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentEarthquake.getMagnitude());

        magnitTextView.setText(output);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

         // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        String string = currentEarthquake.getNameCity();
        boolean retval = string.contains(cs1);
        String part1;
        String part2;

        if (retval) {
            String[] parts = string.split("(?<=of)");
             part1 = parts[0];
             part2 = parts[1];

        }
        else {
             part1 = getContext().getString(R.string.near_the);
             part2 = string;

        }



        TextView city_placeTextView = (TextView) listItemView.findViewById(R.id.city_km);

        city_placeTextView.setText(part1);


        TextView cityPlaceTextView = (TextView) listItemView.findViewById(R.id.city_place);

        cityPlaceTextView.setText(part2);


        Date dateObject = new Date(currentEarthquake.getDate());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        return listItemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private int getMagnitudeColor (double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}









