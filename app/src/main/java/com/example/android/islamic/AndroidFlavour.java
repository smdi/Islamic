package com.example.android.islamic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Imran on 11-12-2017.
 */

public class AndroidFlavour extends ArrayAdapter {


    public static final String LOG_TAG = AndroidFlavour.class.getSimpleName();

    public AndroidFlavour(Activity context, ArrayList<AndroidFlavourHadeesAdapter> androidAdapters) {
        super(context, 0, androidAdapters);
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convert, ViewGroup parent) {
        View listItemView = convert;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listview, parent, false);
        }
        AndroidFlavourHadeesAdapter curr = (AndroidFlavourHadeesAdapter) getItem(position);

        TextView t1 = (TextView) listItemView.findViewById(R.id.version_name);
        t1.setText(curr.mtext);

        TextView t2 = (TextView) listItemView.findViewById(R.id.version_name1);
        t2.setText(curr.mtext1);

        ImageView i1 = (ImageView) listItemView.findViewById(R.id.Image);
        i1.setImageResource(curr.mresourse);

        return listItemView;
    }

}