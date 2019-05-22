package com.example.omniademe.model;

import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;


public class Person {
    private String mName;
    private int mAge;
    private int mHeight;
    private boolean mIsMale;
    private int mImageResID;
    private UUID mUUID;

    public Person() {
        mUUID = UUID.randomUUID();


    }

    /**
     * Setters
     */

    public void setName(String name) {
        mName = name;
    }

    public void setAge(int age) {
        mAge = age;
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

    public int getAge() {
        return mAge;
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
