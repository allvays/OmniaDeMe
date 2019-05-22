package com.example.omniademe.activities;

import android.net.Uri;
import android.os.Bundle;

import com.example.omniademe.R;
import com.example.omniademe.fragments.PersonEditorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements PersonEditorFragment.OnFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
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

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment editPersonFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (editPersonFragment == null){
            editPersonFragment = PersonEditorFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.fragment_container, editPersonFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        /**Do something!!!!!!!!*/
    }
}
