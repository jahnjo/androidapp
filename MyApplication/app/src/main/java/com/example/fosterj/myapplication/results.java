package com.example.fosterj.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by fosterj on 3/21/18.
 */

public class results extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String word = getIntent().getStringExtra("word");
        TextView tv = (TextView)findViewById(R.id.resultString);
    }


}
