package com.example.omniademe.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.omniademe.R;


public class AboutFragment extends Fragment {
    private WebView mWebView;
    private TextView testTextView;
    private Button mButtonThreadJob;

    private AboutFragment() {
    }

    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        testTextView = v.findViewById(R.id.statusTextView);
        mButtonThreadJob = v.findViewById(R.id.doJobButton);
        mWebView = v.findViewById(R.id.webViewAboutFragment);
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
}


