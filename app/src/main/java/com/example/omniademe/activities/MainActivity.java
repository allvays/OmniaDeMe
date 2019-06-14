package com.example.omniademe.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.example.omniademe.R;
import com.example.omniademe.fragments.AboutFragment;
import com.example.omniademe.fragments.InterestingFactsFragment;
import com.example.omniademe.fragments.PersonEditorFragment;
import com.example.omniademe.model.Person;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements PersonEditorFragment.OnSaveButtonPersonFragmentInteractionListener,
        InterestingFactsFragment.OnFragmentInteractionListener {
    private final String TAG = "MainActivity";
    private final String PERSON_EDITOR_TAG = "Person editor";
    private final String INTERESTING_FACT_TAG = "Interesting fact";
    private final String ABOUT_TAG = "About";

    private boolean isPersonCreated = false;
    private FragmentManager fragmentManager;
    private Fragment editPersonFragment;
    private Fragment interestingFactsFragment;
    private Fragment aboutFragment;
    private Context mContext = MainActivity.this;
    private BottomNavigationView mBottomNavigationView;
    private Handler mHandler = new Handler();
    private String mInitiatedFragmentTag;
    private MenuItem mChangePersonMenuItem;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
/*                case R.id.navigation_person:
                    changeFragment(editPersonFragment, false);
                    return true;*/
                case R.id.navigation_dashboard:
                    if (isPersonCreated) {
                        if (!(mBottomNavigationView.getSelectedItemId()==R.id.navigation_dashboard)){
                            changeFragment(interestingFactsFragment, false,INTERESTING_FACT_TAG);
                            return true;
                        }else
                            return false;
                    } else {
                        Toast.makeText(mContext, "Please fill fields AboutFragment you", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                    case R.id.navigation_info:
                        if (!(mBottomNavigationView.getSelectedItemId() == R.id.navigation_info)){
                            changeFragment(aboutFragment,false,ABOUT_TAG);
                            return true;
                        }else
                            return false;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationView = findViewById(R.id.nav_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mChangePersonMenuItem = findViewById(R.id.action_edit_person);
        mContext = this;


        engageFragments();
        changeFragment(editPersonFragment, true, PERSON_EDITOR_TAG);

    }

    private void engageFragments() {
        fragmentManager = getSupportFragmentManager();
        editPersonFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        editPersonFragment = PersonEditorFragment.newInstance();
        interestingFactsFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        interestingFactsFragment = InterestingFactsFragment.newInstance();
        aboutFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        aboutFragment = AboutFragment.newInstance();
    }


    private void changeFragment(Fragment fragment, boolean isFirstCall, String tagFragment) {

        if (mInitiatedFragmentTag!= null){
            if (mInitiatedFragmentTag==tagFragment){
                return;
            }
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tagFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (!isFirstCall) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
        mInitiatedFragmentTag = tagFragment;
        Log.d(TAG, "changeFragment: CREATED FRAGMENT: "+fragment.getTag());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mBottomNavigationView.setVisibility(View.INVISIBLE);
        switch (item.getItemId()){
            case R.id.action_edit_person:
                changeFragment(editPersonFragment,false, PERSON_EDITOR_TAG);
                return true;
        }
        return false;
    }

    @Override
    public void onSaveButtonPersonEditorFragmentInteraction(Person person) {
        Log.d(TAG, "onSaveButtonPersonEditorFragmentInteraction: is called");
        isPersonCreated = true;
        changeFragment(interestingFactsFragment, true, INTERESTING_FACT_TAG);
        mBottomNavigationView.setVisibility(View.VISIBLE);
        Log.d(TAG, "MainActivity  onSaveButtonPersonEditorFragmentInteraction PERSON: age in days "+person.getAgeInDays());
        Log.d(TAG, "MainActivity  onSaveButtonPersonEditorFragmentInteraction PERSON: is male "+person.getIsMale());
        Log.d(TAG, "MainActivity  onSaveButtonPersonEditorFragmentInteraction PERSON: height is "+person.getHeight());
        Log.d(TAG, "MainActivity  onSaveButtonPersonEditorFragmentInteraction PERSON: name is "+person.getName());
        Log.d(TAG, "MainActivity  onSaveButtonPersonEditorFragmentInteraction PERSON: image id "+person.getImageResID());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    public Handler getHandler() {
        return mHandler;
    }
}
