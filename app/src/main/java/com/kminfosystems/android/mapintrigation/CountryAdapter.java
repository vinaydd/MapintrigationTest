package com.kminfosystems.android.mapintrigation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by kmidev on 4/1/16.
 */
public class CountryAdapter extends ArrayAdapter<SpinnerResponce>  {
    Context context;
    TextView textView;
    ArrayList<SpinnerResponce> countries;
    public CountryAdapter(Context context, int resourceId, ArrayList<SpinnerResponce> countries) {
        super(context, resourceId, countries);
        this.context = context;
        this.countries=countries;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflate = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            SpinnerResponce countries = getItem(position);

            if (convertView == null) {
                convertView = mInflate.inflate(R.layout.country_list, null);
                textView= (TextView) convertView.findViewById(R.id.country_name);
                textView.setText(countries.getName());
            }
        return convertView;
    }

}

