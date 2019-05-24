package com.example.omniademe.model;


import android.content.Context;
import android.widget.ImageView;

import java.util.UUID;

public class Fact {
    private UUID mUUID;
    private String mFactTitle;
    private String mDescription;
    private int mFactPicResId;

    public Fact(Context context, int title, int description, int imageResId) {
        mUUID = UUID.randomUUID();
        mFactTitle = context.getString(title);
        mDescription = context.getString(description);
        mFactPicResId = imageResId;
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
