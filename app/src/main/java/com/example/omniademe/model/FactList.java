package com.example.omniademe.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.omniademe.R;

import java.util.ArrayList;
import java.util.List;


public class FactList {
    private static FactList sFactList = null;
    private final String TAG = "FactList";
    private final String HAIR_FACT_TAG = "hair";
    private final String NAILS_FACT_TAG = "nails";
    private final String TOES_FACT_TAG = "toes";

    private List<Fact> mFacts;
    private Context mContext;
    //ListInitiator mListInitiator;

    public static FactList getInstance(Context context) {
        return sFactList = new FactList(context);
        /*if (sFactList == null) {
            return sFactList = new FactList(context);
        } else {
            return sFactList;
        }*/
    }

    public FactList(Context context) {
        //mListInitiator = new ListInitiator();
        mContext = context;
        initiateFactList();


    }

    private void initiateFactList() {
        mFacts = new ArrayList<>();
        mFacts.add(new Fact(mContext, R.string.hair_fact_title, R.string.hair_fact_description, R.drawable.ic_redhead, HAIR_FACT_TAG));
        mFacts.add(new Fact(mContext, R.string.nails_fact_title, R.string.nails_fact_description, R.drawable.ic_hands2, NAILS_FACT_TAG));
        mFacts.add(new Fact(mContext, R.string.toes_fact_title, R.string.toes_fact_description, R.drawable.ic_legs, TOES_FACT_TAG));

    }

    public List<Fact> getFacts() {
        return mFacts;
    }

   /* private class ListInitiator extends AsyncTask<List<Fact>, Void, List<Fact>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Fact> doInBackground(List<Fact>... mFact) {mFacts = new ArrayList<>();
            mFacts.add(new Fact(mContext, R.string.hair_fact_title, R.string.hair_fact_description, R.drawable.hair_pic2, HAIR_FACT_TAG));
            mFacts.add(new Fact(mContext, R.string.nails_fact_title, R.string.nails_fact_description, R.drawable.nails_pic, NAILS_FACT_TAG));
            mFacts.add(new Fact(mContext, R.string.toes_fact_title, R.string.toes_fact_description, R.drawable.toes_pic, TOES_FACT_TAG));
            return mFacts;
        }

        @Override
        protected void onPostExecute(List<Fact> list) {
            super.onPostExecute(list);
            Toast.makeText(mContext, "Finished", Toast.LENGTH_LONG).show();
        }
    }*/
}
