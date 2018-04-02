package com.example.fosterj.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;
//import android.content.Intent;


/**
 * Created by fosterj on 3/21/18.
 */

public class submit extends Activity {

    datahelper helper = new datahelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit);
    }

    public void onSubmitClick(View v) {
        if(v.getId() == R.id.submitButton) {
            EditText synonym = (EditText)findViewById(R.id.enterSyn);
            EditText antonym = (EditText)findViewById(R.id.enterAnt);

            String synStr = synonym.getText().toString();
            String antStr = antonym.getText().toString();

            data d = new data();
            d.setSynonym(synStr);
            d.setAntonym(antStr);

            helper.insertData(d);

            //setContentView(R.layout.submit);

            TextView tv1 = (TextView) findViewById(R.id.submitted);
            TextView tv2 = (TextView) findViewById(R.id.submitted2);
        }

    }
}
