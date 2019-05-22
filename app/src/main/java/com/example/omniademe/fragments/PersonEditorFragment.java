package com.example.omniademe.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omniademe.R;
import com.example.omniademe.model.Person;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PersonEditorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PersonEditorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonEditorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "PersonEditorFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Person mPerson;
    private EditText mNameEditText;
    private EditText mBirthdayEditText;
    private EditText mHeightEditText;
    private RadioGroup mSexRadiogroup;
    private RadioButton mMaleRB;
    private RadioButton mFemaleRB;
    private Button mSaveButton;
    private SeekBar mHeightSeekBar;
    private Context mContext;
    private TextView mHelpingHandSeekBar;


    private OnFragmentInteractionListener mListener;

    public PersonEditorFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PersonEditorFragment newInstance() {
        PersonEditorFragment fragment = new PersonEditorFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mContext = getContext();
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mPerson = new Person();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_person_editor, container, false);


        findViews(v);
        setListeners();

        return v;
    }

    private void findViews(View v) {
        mNameEditText = v.findViewById(R.id.nameEditText);
        mBirthdayEditText = v.findViewById(R.id.birthdayEditText);
        mHeightEditText = v.findViewById(R.id.heightEditText);
        mSexRadiogroup = v.findViewById(R.id.sexRadioGroup);
        mMaleRB = v.findViewById(R.id.maleRB);
        mFemaleRB = v.findViewById(R.id.femaleRB);
        mSaveButton = v.findViewById(R.id.saveChangesButton);
        mHeightSeekBar  = v.findViewById(R.id.heightSeekBar);
        mHelpingHandSeekBar = v.findViewById(R.id.helpingHandTextView);

    }

    private void setListeners() {
        /**
         * Setting Name
         * */
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPerson.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /**
         * Setting height
         * */
        mHeightEditText.setInputType(InputType.TYPE_NULL);
        mHeightEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHeightEditText.setVisibility(View.INVISIBLE);
                mHeightSeekBar.setVisibility(View.VISIBLE);
                mHelpingHandSeekBar.setVisibility(View.VISIBLE);
            }
        });

        /**
         * Determinate Birthday
         * */
        mBirthdayEditText.setInputType(InputType.TYPE_NULL);
        mBirthdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBirthday();
            }
        });

        /**
         * Determinate gender
         * */
        mSexRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.maleRB:
                        mPerson.setMale(true);
                    case R.id.femaleRB:
                        mPerson.setMale(false);
                }
            }
        });

        /**
         * Realizing seekbar
         * */
        mHeightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                mHelpingHandSeekBar.setText(String.valueOf(mHeightSeekBar.getProgress()).concat(" cm"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mHeightEditText.setText("0 cm");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                mHeightEditText.setText(String.valueOf(mHeightSeekBar.getProgress()).concat(" cm"));
                mHeightEditText.setVisibility(View.VISIBLE);
                mHeightSeekBar.setVisibility(View.INVISIBLE);
                mHelpingHandSeekBar.setVisibility(View.INVISIBLE);
            }
        });

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void getBirthday() {
        final DateTime today = new DateTime(new Date());

        Log.d(TAG, today.toString());

        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                if (getView().isShown()) {
                    /**
                     * Calculating years between two dates and setting age
                     * */
                    DateTime then = new DateTime(year, month, day, 0, 0, 0, 0);
                    int mHowmanyDaysILived = Days.daysBetween(then, today).getDays();
                    if (mHowmanyDaysILived > 0) {
                        mPerson.setAge(mHowmanyDaysILived / 365);

                        /**
                         * Setting and formatting text in Edit Text Field
                         * */
                        if ((month + 1) < 10) {
                            if (day < 10) {
                                mBirthdayEditText.setText(String.valueOf(0).concat(String.valueOf(day)).concat(".0")
                                        .concat(String.valueOf(month + 1).concat(".").concat(String.valueOf(year))));
                                Log.d(TAG, "1");
                            } else {
                                mBirthdayEditText.setText(String.valueOf(day).concat(".0")
                                        .concat(String.valueOf(month + 1).concat(".").concat(String.valueOf(year))));
                                Log.d(TAG, "2");
                            }
                            mBirthdayEditText.setText(String.valueOf(day).concat(".0")
                                    .concat(String.valueOf(month + 1).concat(".").concat(String.valueOf(year))));
                        } else {
                            if (day < 10) {
                                mBirthdayEditText.setText(String.valueOf(0).concat(String.valueOf(day)).concat(".")
                                        .concat(String.valueOf(month + 1).concat(".").concat(String.valueOf(year))));
                                Log.d(TAG, "3");
                            } else {
                                mBirthdayEditText.setText(String.valueOf(day).concat(".")
                                        .concat(String.valueOf(month + 1).concat(".").concat(String.valueOf(year))));
                                Log.d(TAG, "4");

                            }
                        }
                    } else {
                        Toast.makeText(mContext, "Don't try to go into the future", Toast.LENGTH_SHORT).show();
                        mBirthdayEditText.setText(null);
                    }


                }

            }

        }, today.getYear(), today.getMonthOfYear(), today.getDayOfMonth());
        datePickerDialog.show();


    }

    /**
     * public void setButtonListener(){
     * mSaveButton.setOnClickListener(new View.OnClickListener() {
     *
     * @Override public void onClick(View view) {
     * mNameEditText.getText();
     * mHeightEditText.getText();
     * <p>
     * <p>
     * <p>
     * }
     * });
     * }
     */

    // TODO: Rename method, update argument and hook method into UI event
    public void onSaveButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
