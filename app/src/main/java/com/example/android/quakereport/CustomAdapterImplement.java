package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.shamdasani on 10/12/2016.
 */

public class CustomAdapterImplement extends ArrayAdapter<CustomAdapter> {

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(
                    R.layout.listlayout, parent, false);
        }
        CustomAdapter customAdapter = getItem(position);
        TextView mag = (TextView)convertView.findViewById(R.id.mag);
        mag.setText(Double.toString(customAdapter.getMag()));
        TextView loc = (TextView)convertView.findViewById(R.id.loc);
        loc.setText(customAdapter.getLocation());
        TextView time = (TextView)convertView.findViewById(R.id.time);
        time.setText(Integer.toString(customAdapter.getTime()));
        return convertView;
    }

    public CustomAdapterImplement(Activity context, ArrayList<CustomAdapter> custom) {
        super(context, 0, custom);
    }
}
