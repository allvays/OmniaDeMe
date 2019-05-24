package com.example.omniademe.model;

import java.util.UUID;


public class Person {
    private String mName;
    private int mAgeInDays;
    private int mHeight;
    private boolean mIsMale;
    private int mImageResID;
    private UUID mUUID;

    public Person() {
        mAgeInDays =0;
        mHeight=0;
        mUUID = UUID.randomUUID();


    }

    /**
     * Setters
     */

    public void setName(String name) {
        mName = name;
    }

    public void setAgeInDays(int ageInDays) {
        mAgeInDays = ageInDays;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public void setMale(boolean male) {
        mIsMale = male;
    }

    public void setImageResID(int imageResID) {
        mImageResID = imageResID;
    }

    /**
     * Getters
     */

    public String getName() {
        return mName;
    }

    public int getAgeInDays() {
        return mAgeInDays;
    }

    public int getHeight() {
        return mHeight;
    }

    public boolean getIsMale() {
        return mIsMale;
    }

    public int getImageResID() {
        return mImageResID;
    }

    public UUID getUUID() {
        return mUUID;
    }
}
