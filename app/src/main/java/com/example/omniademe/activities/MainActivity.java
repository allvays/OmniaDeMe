package com.example.omniademe.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.example.omniademe.R;
import com.example.omniademe.fragments.InterestingFactsFragment;
import com.example.omniademe.fragments.PersonEditorFragment;
import com.example.omniademe.model.Fact;
import com.example.omniademe.model.Person;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements PersonEditorFragment.OnFragmentInteractionListener,
        InterestingFactsFragment.OnFragmentInteractionListener {
    private final String TAG = "MainActivity";

    private static Person mPerson;
    private FragmentManager fragmentManager;
    private Fragment editPersonFragment;
    private Fragment interestingFactsFragment;
    private Context mContext = MainActivity.this;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(editPersonFragment, false);
                    return true;
                case R.id.navigation_dashboard:
                    if (mPerson != null) {
                        changeFragment(interestingFactsFragment, false);
                        return true;
                    } else {
                        Toast.makeText(mContext, "Please fill fields about you", Toast.LENGTH_SHORT).show();
                        return false;
                    }

               /* case R.id.navigation_notifications:

                    return true;*/
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mContext = this;


        fillWithFragment();
        changeFragment(editPersonFragment, true);

    }

    private void fillWithFragment() {
        fragmentManager = getSupportFragmentManager();
        editPersonFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        interestingFactsFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        editPersonFragment = PersonEditorFragment.newInstance();
        interestingFactsFragment = InterestingFactsFragment.newInstance();
    }


    private void changeFragment(Fragment fragment, boolean isFirstCall) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (!isFirstCall) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
        Log.d(TAG, "changeFragment: CREATED");
    }

    public Person getPerson() {
        return mPerson;
    }

    @Override
    public void onFragmentInteraction(Person person) {
        mPerson = person;
        /**Do something!!!!!!!!*/
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
