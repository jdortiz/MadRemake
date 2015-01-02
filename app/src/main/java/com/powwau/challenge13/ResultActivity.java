package com.powwau.challenge13;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ResultActivity extends ActionBarActivity {
    public static final String ADJECTIVE_1 = "adjective1";
    public static final String ADJECTIVE_2 = "adjective2";
    public static final String ADJECTIVE_3 = "adjective3";
    public static final String BODY_PART = "bodyPart";
    public static final String NAME = "name";
    public static final String NAME_IN_ROOM = "nameInRoom";
    public static final String RELATIVE_1 = "relative1";
    public static final String RELATIVE_2 = "relative2";
    public static final String VERB_ED = "verbEd";
    public static final String VERB_ING = "verbIng";

    private String mAdjective1;
    private String mAdjective2;
    private String mAdjective3;
    private String mBodyPart;
    private String mName;
    private String mNameInRoom;
    private String mRelative1;
    private String mRelative2;
    private String mVerbEd;
    private String mVerbIng;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        retrieveParameters();
        prepareTextView();
    }

    private void retrieveParameters () {
        mAdjective1 = getIntent().getStringExtra(ADJECTIVE_1);
        mAdjective2 = getIntent().getStringExtra(ADJECTIVE_2);
        mAdjective3 = getIntent().getStringExtra(ADJECTIVE_3);
        mBodyPart   = getIntent().getStringExtra(BODY_PART);
        mName       = getIntent().getStringExtra(NAME);
        mNameInRoom = getIntent().getStringExtra(NAME_IN_ROOM);
        mRelative1  = getIntent().getStringExtra(RELATIVE_1);
        mRelative2  = getIntent().getStringExtra(RELATIVE_2);
        mVerbEd     = getIntent().getStringExtra(VERB_ED);
        mVerbIng    = getIntent().getStringExtra(VERB_ING);
    }

    private void prepareTextView () {
        mTextView = (TextView)findViewById(R.id.result_text_view);
        mTextView.setText(generateText());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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

    private String generateText() {
        return "My " + mRelative1 + " heard a " + mAdjective1 + " noise." +
                "The " + mAdjective2 + " rain outside was more than " + mNameInRoom +
                " had anticipated. Too " + mAdjective3 + "! It " + mVerbEd +
                " my " + mBodyPart + " while " + mVerbIng + " " + mRelative2 +
                " to shout \"" + mName + "!\"";
    }
}
