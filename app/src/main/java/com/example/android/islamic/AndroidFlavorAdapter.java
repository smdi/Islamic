package com.example.android.islamic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Imran on 10-12-2017.
 */

public class AndroidFlavorAdapter extends ArrayAdapter<Androidflavor> {

    private static final String LOG_TAG = AndroidFlavorAdapter.class.getSimpleName();

    public AndroidFlavorAdapter(Context context, ArrayList<Androidflavor> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Androidflavor currentAndroidFlavor = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.version_name);
        nameTextView.setText(currentAndroidFlavor.getVersionName());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentAndroidFlavor.getImageResourceId());

        return listItemView;
    }

}
