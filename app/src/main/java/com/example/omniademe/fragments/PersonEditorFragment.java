package com.example.omniademe.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omniademe.R;
import com.example.omniademe.model.Person;

import org.joda.time.DateTime;
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
    private static final String TAG = "PersonEditorFragment";

    private Context mContext;
    private Person mPerson;
    private EditText mNameEditText;
    private EditText mBirthdayEditText;
    private EditText mHeightEditText;
    private RadioGroup mSexRadiogroup;
    private Button mSaveButton;
    private SeekBar mHeightSeekBar;
    private boolean mIsSexSet = false;
    private TextView mHelpingHandSeekBar;
    private TextView mGenderTextView;


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
        super.onCreate(savedInstanceState);
        mContext = getContext();
        if (getArguments() != null) {
        }
        mPerson = new Person();
        Log.d(TAG, "onCreate: success");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_person_editor, container, false);

        findViews(v);
        setListeners();
        Log.d(TAG, "onCreateView: CREATED VIEW");
        return v;
    }

    private void findViews(View v) {
        mNameEditText = v.findViewById(R.id.nameEditText);
        mBirthdayEditText = v.findViewById(R.id.birthdayEditText);
        mHeightEditText = v.findViewById(R.id.heightEditText);
        mSexRadiogroup = v.findViewById(R.id.sexRadioGroup);
        mSaveButton = v.findViewById(R.id.saveChangesButton);
        mHeightSeekBar = v.findViewById(R.id.heightSeekBar);
        mHelpingHandSeekBar = v.findViewById(R.id.helpingHandTextView);
        mGenderTextView = v.findViewById(R.id.gender_text_view);


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
                mIsSexSet = true;
                mSexRadiogroup.setBackgroundColor(Color.TRANSPARENT);
                switch (i) {
                    case R.id.maleRB:
                        mPerson.setMale(true);
                        break;
                    case R.id.femaleRB:
                        mPerson.setMale(false);
                        break;
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
                mPerson.setHeight(mHeightSeekBar.getProgress());
                mHeightEditText.setBackgroundColor(Color.TRANSPARENT);
                mHeightEditText.setVisibility(View.VISIBLE);
                mHeightSeekBar.setVisibility(View.INVISIBLE);
                mHelpingHandSeekBar.setVisibility(View.INVISIBLE);
            }
        });

        /**
        * Realizing button
        * */
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((mNameEditText.getText().length() != 0) && (mBirthdayEditText.getText().length() != 0)
                        && (mHeightEditText.getText().length() != 0) && mIsSexSet) {
                    mNameEditText.setEnabled(false);
                    mNameEditText.setCursorVisible(false);
                    mNameEditText.setBackgroundColor(Color.TRANSPARENT);
                    mNameEditText.setTextColor(Color.BLACK);
                    mNameEditText.setKeyListener(null);

                    mBirthdayEditText.setEnabled(false);
                    mBirthdayEditText.setCursorVisible(false);
                    mBirthdayEditText.setBackgroundColor(Color.TRANSPARENT);
                    mBirthdayEditText.setKeyListener(null);
                    mBirthdayEditText.setTextColor(Color.BLACK);

                    mHeightEditText.setEnabled(false);
                    mHeightEditText.setCursorVisible(false);
                    mHeightEditText.setBackgroundColor(Color.TRANSPARENT);
                    mHeightEditText.setKeyListener(null);
                    mHeightEditText.setTextColor(Color.BLACK);

                    mSexRadiogroup.setVisibility(View.INVISIBLE);
                    mGenderTextView.setVisibility(View.VISIBLE);
                    mGenderTextView.setTextColor(Color.BLACK);
                    Log.d(TAG, String.valueOf(mPerson.getIsMale()));

                    if (mPerson.getIsMale()) {
                        mGenderTextView.setText("Male");
                    } else {
                        mGenderTextView.setText("Female");
                    }


                } else {
                    if ((mNameEditText.getText().length() == 0)) {
                        mNameEditText.setBackgroundColor(Color.rgb(247, 153, 153));
                    }
                    if ((mBirthdayEditText.getText().length() == 0)) {
                        mBirthdayEditText.setBackgroundColor(Color.rgb(247, 153, 153));
                    }
                    if ((mHeightEditText.getText().length() == 0)) {
                        mHeightEditText.setBackgroundColor(Color.rgb(247, 153, 153));
                    }
                    if (!mIsSexSet) {
                        mSexRadiogroup.setBackgroundColor(Color.rgb(247, 153, 153));
                    }
                }
                if (mListener != null) {
                    mListener.onFragmentInteraction(mPerson);
                }
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
                    Log.d(TAG, "onDateSet: " + mHowmanyDaysILived);
                    if (mHowmanyDaysILived >= 1095) {
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
                        mBirthdayEditText.setBackgroundColor(Color.TRANSPARENT);
                    } else {
                        if (mHowmanyDaysILived > 0) {
                            Toast.makeText(mContext, "You can't be younger 3 y.o.", Toast.LENGTH_SHORT).show();
                            mBirthdayEditText.setText(null);
                        } else {
                            Toast.makeText(mContext, "Don't try to go into the future", Toast.LENGTH_SHORT).show();
                            mBirthdayEditText.setText(null);
                        }

                    }


                }

            }

        }, today.getYear(), today.getMonthOfYear(), today.getDayOfMonth());
        datePickerDialog.show();


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
        Log.d(TAG, "onAttach: ATTACHED");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.d(TAG, "onDetach: DETACHED");
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
        void onFragmentInteraction(Person person);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: RESUMED");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: PAUSED");
    }
}
