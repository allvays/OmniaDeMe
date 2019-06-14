package com.example.omniademe.model;

public class Person {
    private static String mName;
    private static int mAgeInDays =0;
    private static int mHeight = 0;
    private static boolean mIsMale;
    private static int mImageResID;

    /**
     * Close access to the constructor
     */
    private Person() {
    }

    private static class PersonSingletonHolder {
        private static final Person HOLDER_INSTANCE = new Person();

    }

    public static Person getPerson() {
        return PersonSingletonHolder.HOLDER_INSTANCE;
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
}
