package com.example.android.islamic;

/**
 * Created by Imran on 10-12-2017.
 */

public class Androidflavor {



    private String mVersionName;

    private int mImageResourceId;

    public Androidflavor(String vName , int imageResourceId)
    {
        mVersionName = vName;

        mImageResourceId = imageResourceId;
    }

    public String getVersionName() {
        return mVersionName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

}
