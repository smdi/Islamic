package com.example.android.islamic;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class Alarm  extends BroadcastReceiver{
    int global, idName;
    Context applicationContext;


    @Override
    public void onReceive(Context context, Intent intent) {

        Vibrator v =(Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
        v.vibrate(1000);

        MediaPlayer mp = MediaPlayer.create(context ,R.raw.message_bell_s8);
        mp.start();




        Toast.makeText(context, "its Hadees Time", Toast.LENGTH_LONG).show();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String title = category(context);
        String message = hadees(context);



        Intent i1 = new Intent(context, Alarm.class);
        PendingIntent pi1 = PendingIntent.getActivity(context, 1, i1, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.BigTextStyle  bigTextStyle  = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(message);
        bigTextStyle.setBigContentTitle(title);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setColor(Color.WHITE)
                        .setLights(1,1,1)
                        .setSmallIcon(R.drawable.had1, 1)
                        .setContentText(" Slide down to read completely ")
                        .setAutoCancel(true)
                        .setStyle(bigTextStyle)
                        .setContentIntent(pi1);


        NotificationManager nf = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        nf.notify(0, mBuilder.build());

    }

    private String category(Context v) {

        global = load(v);

        String message = "";

        switch (global) {

            case 1:
                message =" HADITH ON  NAMAZ ";

                break;

            case 2:
                message =" HADITH ON ZAKAT ";
                break;

            case 3:
                message = " HADITH ON FASTING";
                break;



        }
        return message;
    }

    private String hadees(Context v) {

        global = load(v);

        String message = "";

        switch (global) {

            case 1:
                message = " Hadees 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
                store(2, v);
                break;

            case 2:
                message = " Hadees 22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 ";
                store(3, v);
                break;

            case 3:
                message = " Hadees 3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333 ";
                store(1, v);
                break;



        }
        return message;
    }

    public void store(int iN, Context v) {

        try {

            SharedPreferences prefs =
                    PreferenceManager.getDefaultSharedPreferences(v);

            SharedPreferences.Editor editor = prefs.edit();

            editor.putInt("var", iN);

            editor.commit();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int load(Context v) {

        int in;
        try {


            SharedPreferences prefs =
                    PreferenceManager.getDefaultSharedPreferences(v);

            in = prefs.getInt("var", 1);
            global = in;


        } catch (NullPointerException e) {
            e.printStackTrace();

        }
        return global;
    }

}
