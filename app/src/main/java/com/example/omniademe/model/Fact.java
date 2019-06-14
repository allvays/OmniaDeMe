package com.example.omniademe.model;


import android.content.Context;
import android.util.Log;

import com.example.omniademe.R;

import java.util.UUID;

public class Fact {
    private UUID mUUID;
    private String mFactTitle;
    private String mDescription;
    //private String mFactPicUrl;
    private int mFactPicResId;

    public Fact(Context context, int title, int description, int factPicResId, String TAG) {
        mUUID = UUID.randomUUID();
        int days = Person.getPerson().getAgeInDays();
        Log.d(TAG, "Fact: days is" + days);
        //mFactPicUrl = uri;
        mFactPicResId = factPicResId;
        mFactTitle = context.getString(title);
        switch (TAG) {
            case "hair":
                mDescription = context.getString(description).concat(" ").concat(String.valueOf(Double.valueOf(days * 0.033).intValue())
                        .concat(" cm"));
                break;
            case "nails":
                mDescription = context.getString(description).concat(" ").concat(String.valueOf(Double.valueOf(days * 0.043).intValue())
                        .concat(" cm"));
                break;
            case "toes":
                mDescription = context.getString(description).concat(" ").concat(String.valueOf(Double.valueOf(days * 0.0036).intValue())
                        .concat(" cm"));
                break;
        }

    }
    public Fact (Context context){
        mUUID = UUID.randomUUID();
        mFactTitle = context.getString(R.string.welcoming_title).concat(" ").concat(Person.getPerson().getName().concat("!"));
        mDescription = context.getString(R.string.welcoming_description);
        mFactPicResId = Person.getPerson().getImageResID();
    }


    /**
     * Getters
     */
    public UUID getUUID() {
        return mUUID;
    }

    public String getFactTitle() {
        return mFactTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    /*public String getFactPicUrl() {
        return mFactPicUrl;
    }*/

    public int getFactResId() {
        return mFactPicResId;
    }
}
