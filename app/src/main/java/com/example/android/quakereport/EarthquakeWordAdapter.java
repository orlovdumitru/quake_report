package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;



/**
 * Created by dima on 3/17/17.
 */

public class EarthquakeWordAdapter extends ArrayAdapter<EarthquakeInfo> {

    String primaryLocation;
    String locationOffset;
    final String LOCATION_SEPARATOR = " of ";

    public EarthquakeWordAdapter(Activity context, ArrayList<EarthquakeInfo> erthquakeWordAdapter){
        super(context, 0, erthquakeWordAdapter);


    }


            /**
             * metoda aceasta e folosita pentru a crea elementul din lista noastra
             * penntru ca mai apoi incarcat cu informnatia primita din obiectul creat
             * mai inainte de noi (EarthquaqeInfo) adica scale, cityName si data
             */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){



        View listItemView = convertView;
        if (listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        EarthquakeInfo earthquakeInfo = getItem(position);

        DecimalFormat numberFormat = new DecimalFormat("0.0");
        double magInDouble = Double.parseDouble(earthquakeInfo.getQuakeScale());
        String magnitudine = numberFormat.format(magInDouble);
        TextView textViewScale = (TextView) listItemView.findViewById(R.id.eqScale);

            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) textViewScale.getBackground();

            // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(magInDouble);

            // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        textViewScale.setText(magnitudine);

            //Selectam Locatia unde a avut loc Cutremurul
            //Selectam Locatia cu ajutorul getCityName
        String textCity = earthquakeInfo.getCityName();
        if (textCity.contains(LOCATION_SEPARATOR)) {
            String[] parts = textCity.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = textCity;
        }
        TextView textViewCity = (TextView) listItemView.findViewById(R.id.eqCity);
        textViewCity.setText(primaryLocation);

        TextView textViewCityDistance = (TextView) listItemView.findViewById(R.id.eqOffSet);
        textViewCityDistance.setText(locationOffset);


            //Selectam data cind a avut loc cutremurul
            //acest pas ne ajuta sa modificam din milisecunde ne transforma in
            //Data ora cind a avut loc acel cutremul ca sa fie pe intelese pentru utilizator
        long timeInMilisecond = Long.parseLong(earthquakeInfo.getQuakeDate());
        Date dateObject = new Date(timeInMilisecond);
            //Prntru aceasta noi o sa folosim Simple Date format
        SimpleDateFormat dateFormater = new SimpleDateFormat("MMM/dd/yyyy");
        String timeInString = dateFormater.format(dateObject);
        TextView textViewDate = (TextView) listItemView.findViewById(R.id.eqDate);
        textViewDate.setText(timeInString);

        SimpleDateFormat timeFormater = new SimpleDateFormat("HH:mm:ss");
        String timeString = timeFormater.format(dateObject);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.eqHour);
        timeTextView.setText(timeString);

        return listItemView;
   }
    public int getMagnitudeColor (double mag) {
        if (mag <= 2)
            return ContextCompat.getColor(getContext(), R.color.magnitude1);
        else if (mag > 2 & mag <= 3)
            return ContextCompat.getColor(getContext(), R.color.magnitude2);
        else if (mag > 3 & mag <= 4)
            return ContextCompat.getColor(getContext(), R.color.magnitude3);
        else if (mag > 4 & mag <= 5)
            return ContextCompat.getColor(getContext(), R.color.magnitude4);
        else if (mag > 5 & mag <= 6)
            return ContextCompat.getColor(getContext(), R.color.magnitude5);
        else if (mag > 6 & mag <= 7)
            return ContextCompat.getColor(getContext(), R.color.magnitude6);
        else if (mag > 7 & mag <= 8)
            return ContextCompat.getColor(getContext(), R.color.magnitude7);
        else if (mag > 8 & mag <= 9)
            return ContextCompat.getColor(getContext(), R.color.magnitude8);
        else if (mag > 9 & mag <= 10)
            return ContextCompat.getColor(getContext(), R.color.magnitude9);
        else if (mag > 10)
            return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        else
        return 0;
    }
}
