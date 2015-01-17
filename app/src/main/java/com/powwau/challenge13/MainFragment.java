package com.powwau.challenge13;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.EnumSet;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    final static String LOG_TAG = MainFragment.class.getSimpleName();
    final static String FIELD = "FIELD";

    private EditText mAdjective1EditText;
    private EditText mAdjective2EditText;
    private EditText mAdjective3EditText;
    private EditText mBodyPartEditText;
    private EditText mNameEditText;
    private EditText mNameInRoomEditText;
    private EditText mRelative1EditText;
    private EditText mRelative2EditText;
    private EditText mVerbEdEditText;
    private EditText mVerbIngEditText;
    private Button mButton;

    private enum FilledFields {
        Adjective1Filled,
        Adjective2Filled,
        Adjective3Filled,
        BodyPartFilled,
        NameFilled,
        NameInRoomFilled,
        Relative1Filled,
        Relative2Filled,
        VerbEdFilled,
        VerbIngFilled
    }
    EnumSet<FilledFields> mFilledFieldsEnumSet = EnumSet.noneOf(FilledFields.class);

    private static class FormState {
        Boolean mAdjective1Filled;

        public Boolean isAdjective1Filled() {
            return mAdjective1Filled;
        }

        public void setAdjective1Filled(Boolean adjective1Filled) {
            mAdjective1Filled = adjective1Filled;
        }
    }

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Creating fragment.");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Activity created.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Creating fragment view.");
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        prepareViews(rootView);
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(FIELD + Integer.toString(FilledFields.Adjective1Filled.ordinal()))) {
                mFilledFieldsEnumSet.add(FilledFields.Adjective1Filled);
            }
        }
        return rootView;
    }

    private void prepareViews(View rootView) {
        prepareAdjective1EditText(rootView);
        prepareAdjective1EditText(rootView);
        prepareAdjective2EditText(rootView);
        prepareAdjective3EditText(rootView);
        prepareBodyPartEditText(rootView);
        prepareNameEditText(rootView);
        prepareNameInRoomEditText(rootView);
        prepareRelative1EditText(rootView);
        prepareRelative2EditText(rootView);
        prepareVerbEdEditText(rootView);
        prepareVerbIngEditText(rootView);
        prepareButton(rootView);
    }

    private void prepareAdjective1EditText (View rootView) {
        mAdjective1EditText = (EditText)rootView.findViewById(R.id.edit_text_adjective_1);
        mAdjective1EditText.addTextChangedListener(new ContentWatcher(FilledFields.Adjective1Filled));
    }

    private void prepareAdjective2EditText (View rootView) {
        mAdjective2EditText = (EditText)rootView.findViewById(R.id.edit_text_adjective_2);
        mAdjective2EditText.addTextChangedListener(new ContentWatcher(FilledFields.Adjective2Filled));
    }

    private void prepareAdjective3EditText (View rootView) {
        mAdjective3EditText = (EditText)rootView.findViewById(R.id.edit_text_adjective_3);
        mAdjective3EditText.addTextChangedListener(new ContentWatcher(FilledFields.Adjective3Filled));
    }

    private void prepareBodyPartEditText (View rootView) {
        mBodyPartEditText = (EditText)rootView.findViewById(R.id.edit_text_body_part);
        mBodyPartEditText.addTextChangedListener(new ContentWatcher(FilledFields.BodyPartFilled));
    }

    private void prepareNameEditText (View rootView) {
        mNameEditText = (EditText)rootView.findViewById(R.id.edit_text_name);
        mNameEditText.addTextChangedListener(new ContentWatcher(FilledFields.NameFilled));
    }

    private void prepareNameInRoomEditText (View rootView) {
        mNameInRoomEditText = (EditText)rootView.findViewById(R.id.edit_text_name_in_room);
        mNameInRoomEditText.addTextChangedListener(new ContentWatcher(FilledFields.NameInRoomFilled));
    }

    private void prepareRelative1EditText (View rootView) {
        mRelative1EditText= (EditText)rootView.findViewById(R.id.edit_text_relative_1);
        mRelative1EditText.addTextChangedListener(new ContentWatcher(FilledFields.Relative1Filled));
    }

    private void prepareRelative2EditText (View rootView) {
        mRelative2EditText = (EditText)rootView.findViewById(R.id.edit_text_relative_2);
        mRelative2EditText.addTextChangedListener(new ContentWatcher(FilledFields.Relative2Filled));
    }

    private void prepareVerbEdEditText (View rootView) {
        mVerbEdEditText = (EditText)rootView.findViewById(R.id.edit_text_verb_ed);
        mVerbEdEditText.addTextChangedListener(new ContentWatcher(FilledFields.VerbEdFilled));
    }

    private void prepareVerbIngEditText (View rootView) {
        mVerbIngEditText = (EditText)rootView.findViewById(R.id.edit_text_verb_ing);
        mVerbIngEditText.addTextChangedListener(new ContentWatcher(FilledFields.VerbIngFilled));
    }

    private void prepareButton(View rootView) {
        mButton = (Button)rootView.findViewById(R.id.button_show_me);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra(ResultActivity.ADJECTIVE_1, mAdjective1EditText.getText().toString());
                intent.putExtra(ResultActivity.ADJECTIVE_2, mAdjective2EditText.getText().toString());
                intent.putExtra(ResultActivity.ADJECTIVE_3, mAdjective3EditText.getText().toString());
                intent.putExtra(ResultActivity.BODY_PART, mBodyPartEditText.getText().toString());
                intent.putExtra(ResultActivity.NAME, mNameEditText.getText().toString());
                intent.putExtra(ResultActivity.NAME_IN_ROOM, mNameInRoomEditText.getText().toString());
                intent.putExtra(ResultActivity.RELATIVE_1, mRelative1EditText.getText().toString());
                intent.putExtra(ResultActivity.RELATIVE_2, mRelative2EditText.getText().toString());
                intent.putExtra(ResultActivity.VERB_ED, mVerbEdEditText.getText().toString());
                intent.putExtra(ResultActivity.VERB_ING, mVerbIngEditText.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Resuming fragment.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Pausing fragment.");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FormState formState = new FormState();
        formState.setAdjective1Filled(mFilledFieldsEnumSet.contains(FilledFields.Adjective1Filled));

        outState.putBoolean(FIELD + Integer.toString(FilledFields.Adjective1Filled.ordinal()),
                mFilledFieldsEnumSet.contains(FilledFields.Adjective1Filled));
    }

    public class ContentWatcher implements TextWatcher {
        FilledFields mField;
        public ContentWatcher(FilledFields field) {
            mField = field;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().isEmpty()) {
                mFilledFieldsEnumSet.remove(mField);
            } else {
                mFilledFieldsEnumSet.add(mField);
            }
            changeButtonStatus();
        }
    }

    private void changeButtonStatus () {
        if (mFilledFieldsEnumSet.containsAll(EnumSet.allOf(FilledFields.class))) {
            mButton.setEnabled(true);
        } else {
            mButton.setEnabled(false);
        }
    }
}
