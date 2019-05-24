package com.example.omniademe.model;


import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.example.omniademe.activities.MainActivity;

import java.util.UUID;

public class Fact {
    private UUID mUUID;
    private String mFactTitle;
    private String mDescription;
    private int mFactPicResId;

    public Fact(Context context, int title, int description, int imageResId, String TAG) {
        mUUID = UUID.randomUUID();
        int days = new MainActivity().getPerson().getAgeInDays();
        Log.d(TAG, "Fact: days is"+days);
        mFactPicResId = imageResId;
        mFactTitle = context.getString(title);
        switch (TAG){
            case "hair":
                mDescription = context.getString(description).concat(" ").concat(String.valueOf(Double.valueOf(days*0.033).intValue())
                        .concat(" cm"));
                break;
            case "nails":
                mDescription = context.getString(description).concat(" ").concat(String.valueOf(Double.valueOf(days*0.043).intValue())
                        .concat(" cm"));
                break;
            case "toes":
                mDescription = context.getString(description).concat(" ").concat(String.valueOf(Double.valueOf(days*0.0036).intValue())
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

    public int getFactPicResId() {
        return mFactPicResId;
    }
}
