package com.powwau.challenge13;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.EnumSet;


public class MainActivity extends ActionBarActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareViews();
    }

    private void prepareViews() {
        prepareAdjective1EditText();
        prepareAdjective1EditText();
        prepareAdjective2EditText();
        prepareAdjective3EditText();
        prepareBodyPartEditText();
        prepareNameEditText();
        prepareNameInRoomEditText();
        prepareRelative1EditText();
        prepareRelative2EditText();
        prepareVerbEdEditText();
        prepareVerbIngEditText();
        prepareButton();
    }

    private void prepareAdjective1EditText () {
        mAdjective1EditText = (EditText)findViewById(R.id.edit_text_adjective_1);
        mAdjective1EditText.addTextChangedListener(new ContentWatcher(FilledFields.Adjective1Filled));
    }

    private void prepareAdjective2EditText () {
        mAdjective2EditText = (EditText)findViewById(R.id.edit_text_adjective_2);
        mAdjective2EditText.addTextChangedListener(new ContentWatcher(FilledFields.Adjective2Filled));
    }

    private void prepareAdjective3EditText () {
        mAdjective3EditText = (EditText)findViewById(R.id.edit_text_adjective_3);
        mAdjective3EditText.addTextChangedListener(new ContentWatcher(FilledFields.Adjective3Filled));
    }

    private void prepareBodyPartEditText () {
        mBodyPartEditText = (EditText)findViewById(R.id.edit_text_body_part);
        mBodyPartEditText.addTextChangedListener(new ContentWatcher(FilledFields.BodyPartFilled));
    }

    private void prepareNameEditText () {
        mNameEditText = (EditText)findViewById(R.id.edit_text_name);
        mNameEditText.addTextChangedListener(new ContentWatcher(FilledFields.NameFilled));
    }

    private void prepareNameInRoomEditText () {
        mNameInRoomEditText = (EditText)findViewById(R.id.edit_text_name_in_room);
        mNameInRoomEditText.addTextChangedListener(new ContentWatcher(FilledFields.NameInRoomFilled));
    }

    private void prepareRelative1EditText () {
        mRelative1EditText= (EditText)findViewById(R.id.edit_text_relative_1);
        mRelative1EditText.addTextChangedListener(new ContentWatcher(FilledFields.Relative1Filled));
    }

    private void prepareRelative2EditText () {
        mRelative2EditText = (EditText)findViewById(R.id.edit_text_relative_2);
        mRelative2EditText.addTextChangedListener(new ContentWatcher(FilledFields.Relative2Filled));
    }

    private void prepareVerbEdEditText () {
        mVerbEdEditText = (EditText)findViewById(R.id.edit_text_verb_ed);
        mVerbEdEditText.addTextChangedListener(new ContentWatcher(FilledFields.VerbEdFilled));
    }

    private void prepareVerbIngEditText () {
        mVerbIngEditText = (EditText)findViewById(R.id.edit_text_verb_ing);
        mVerbIngEditText.addTextChangedListener(new ContentWatcher(FilledFields.VerbIngFilled));
    }

    private void prepareButton() {
        mButton = (Button)findViewById(R.id.button_show_me);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeButtonStatus () {
        if (mFilledFieldsEnumSet.containsAll(EnumSet.allOf(FilledFields.class))) {
            mButton.setEnabled(true);
        } else {
            mButton.setEnabled(false);
        }
    }
}
