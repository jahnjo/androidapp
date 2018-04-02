package com.example.fosterj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    datahelper helper = new datahelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onFindClick(View v) {
        if(v.getId() == R.id.button) {
            //Intent i = new Intent(MainActivity.this, results.class);
            //startActivity(i);

            EditText word = (EditText)findViewById(R.id.userInput);
            String input = word.getText().toString();

            String antResult = helper.searchAnt(input);
            String synResult = helper.searchSyn(input);

            if (input.equals(antResult) || input.equals(synResult)) {



                Intent i = new Intent(MainActivity.this, results.class);
                i.putExtra("word", input);
                startActivity(i);


            }
        }

    }

    public void onEnterClick(View v) {
        if(v.getId() == R.id.button2) {
            Intent i = new Intent(MainActivity.this, submit.class);
            startActivity(i);
        }

    }

}
