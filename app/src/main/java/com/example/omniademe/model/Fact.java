package com.example.omniademe.model;


import android.content.Context;
import android.util.Log;

import java.util.UUID;

public class Fact {
    private UUID mUUID;
    private String mFactTitle;
    private String mDescription;
    private String mFactPicUrl;
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

    public String getFactPicUrl() {
        return mFactPicUrl;
    }

    public int getFactResId() {
        return mFactPicResId;
    }
}
