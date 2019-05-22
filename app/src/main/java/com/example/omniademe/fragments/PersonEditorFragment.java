package com.example.omniademe.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.omniademe.R;


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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText mNameEditText;
    private EditText mBirthdayEditText;
    private EditText mHeightEditText;
    private RadioGroup mSexRadiogroup;
    private RadioButton mMaleRB;
    private RadioButton mFemaleRB;
    private Button mSaveButton;


    private OnFragmentInteractionListener mListener;

    public PersonEditorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonEditorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonEditorFragment newInstance(String param1, String param2) {
        PersonEditorFragment fragment = new PersonEditorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_person_editor, container, false);

        mNameEditText = v.findViewById(R.id.nameEditText);
        mBirthdayEditText = v.findViewById(R.id.birthdayEditText);
        mHeightEditText = v.findViewById(R.id.heightEditText);
        mSexRadiogroup = v.findViewById(R.id.sexRadioGroup);
        mMaleRB = v.findViewById(R.id.maleRB);
        mFemaleRB = v.findViewById(R.id.femaleRB);
        mSaveButton = v.findViewById(R.id.saveChangesButton);

        return v;
    }

    /**
     * // TODO: Rename method, update argument and hook method into UI event
     * public void onButtonPressed(Uri uri) {
     * if (mListener != null) {
     * mListener.onFragmentInteraction(uri);
     * }
     * }
     */

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
