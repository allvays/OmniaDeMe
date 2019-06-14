package com.example.omniademe.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omniademe.R;
import com.example.omniademe.model.Fact;
import com.example.omniademe.model.FactList;


import java.util.List;




public class InterestingFactsFragment extends Fragment {
    private final String TAG = "InterestingFactsFragment";
    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private FactAdapter mFactAdapter;
    private List<Fact> mFacts;


    public static InterestingFactsFragment newInstance() {
        InterestingFactsFragment fragment = new InterestingFactsFragment();
        return fragment;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSaveButtonPersonFragmentInteractionListener");
        }
        Log.d(TAG, "Interesting fact fragment onAttach: ATTACHED");
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interesting_facts, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        mFacts = FactList.getInstance(getContext()).getFacts();
        mFactAdapter = new FactAdapter(mFacts, getContext());

        mRecyclerView.setAdapter(mFactAdapter);
        mRecyclerView.setLayoutManager(layoutManager);

        Log.d(TAG, "onCreateView: CALLED");
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


    /**
     * Adapter
     */
    private class FactAdapter extends RecyclerView.Adapter<FactHolder> {
        private List<Fact> mFacts;
        Context mContext;

        public FactAdapter(List<Fact> facts, Context context) {
            mFacts = facts;
            mContext = context;
        }

        @NonNull
        @Override
        public FactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.interesting_facts_item,
                    parent, false);
            return new FactHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull FactHolder holder, final int position) {
            Fact fact = mFacts.get(position);
            holder.mTitleText.setText(fact.getFactTitle());
            holder.mDescription.setText(fact.getDescription());
            holder.mImageView.setImageResource(fact.getFactResId());
           // Picasso.with(mContext).load(fact.getFactPicUrl()).into(holder.mImageView);

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Position" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            if (mFacts != null) {
                return mFacts.size();
            } else {
                return 0;
            }

        }
    }

    /**
     * ViewHolder
     */
    private class FactHolder extends RecyclerView.ViewHolder {
        private CardView mCardView;
        private TextView mTitleText;
        private TextView mDescription;
        private ImageView mImageView;

        public FactHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.factPicture);
            mCardView = itemView.findViewById(R.id.item_card_view);
            mTitleText = itemView.findViewById(R.id.factTitleTextView);
            mDescription = itemView.findViewById(R.id.factDescriptionTextView);

        }
    }
}


