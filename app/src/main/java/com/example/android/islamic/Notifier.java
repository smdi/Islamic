package com.example.android.islamic;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notifier extends Fragment {

    TimePicker tp;
    int idName;
    public static final  long one_minute = 3000;
    Button b1,b2;

    public Notifier() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_notifier, container, false);


        return view;
    }


}
