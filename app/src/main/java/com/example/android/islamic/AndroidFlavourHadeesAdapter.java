package com.example.android.islamic;

/**
 * Created by Imran on 11-12-2017.
 */

public class AndroidFlavourHadeesAdapter {

    int mresourse;

    String mtext,mtext1;

    public AndroidFlavourHadeesAdapter(String mtext ,String mtext1 ,int mresourse)
    {
        this.mresourse=mresourse;
        this.mtext=mtext;
        this.mtext1=mtext1;
    }

    public int iconResource()
    {
     return mresourse;
    }

    public String listText()
    {
        return mtext;
    }
    public String listTextfor()
    {
        return mtext1;
    }

}
