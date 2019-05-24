package com.example.omniademe.model;

import android.content.Context;

import com.example.omniademe.R;

import java.util.ArrayList;
import java.util.List;

public class FactList {
    private static FactList sFactList = null;

    private List<Fact> mFacts;
    private Context mContext;

    public static FactList getInstance(Context context){
        if (sFactList == null){
            return sFactList = new FactList(context);
        }else{
            return sFactList;
        }
    }

    public FactList(Context context) {
        mContext = context;
        initiateFactList();
    }

    private void initiateFactList() {
        mFacts = new ArrayList<>();
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
        mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum,1));
    }

    public List<Fact> getFacts() {
        return mFacts;
    }
}
