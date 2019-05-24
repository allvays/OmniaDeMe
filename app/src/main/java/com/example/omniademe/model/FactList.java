package com.example.omniademe.model;

import android.content.Context;

import com.example.omniademe.R;

import java.util.ArrayList;
import java.util.List;

public class FactList {
    private static FactList sFactList = null;
    private final String HAIR_FACT_TAG= "hair";
    private final String NAILS_FACT_TAG= "nails";
    private final String TOES_FACT_TAG= "toes";

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
        mFacts.add(new Fact(mContext, R.string.hair_fact_title,R.string.hair_fact_description,R.drawable.hair_pic2,HAIR_FACT_TAG));
        mFacts.add(new Fact(mContext, R.string.nails_fact_title,R.string.nails_fact_description,R.drawable.nails_pic,NAILS_FACT_TAG));
        mFacts.add(new Fact(mContext, R.string.toes_fact_title,R.string.toes_fact_description,R.drawable.toes_pic,TOES_FACT_TAG));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
        //mFacts.add(new Fact(mContext, R.string.fact_title,R.string.ipsum_short,1));
    }

    public List<Fact> getFacts() {
        return mFacts;
    }
}
