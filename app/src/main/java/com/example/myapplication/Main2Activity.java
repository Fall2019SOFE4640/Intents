/*
Auther : Anwar Abdalbari
Date: Sept. 23, 2019
Purpose: Activity 2 Intent
 */

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //create an intent
       Intent intent2 = getIntent();

       //add the two numbers to the intent
        final int number1 = intent2.getIntExtra("number1",0);
        final int number2 = intent2.getIntExtra("number2",0);

        //display the  numbers
        TextView textView = (TextView)findViewById(R.id.lblNumbers);
        textView.setText("The numbers are: "+ number1 + " , " + number2);


        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSub = (Button) findViewById(R.id.btnSub);

        //create btnadd listener
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int result = number1+number2;
              Intent resutlIntent = new Intent();
                //send the result back to activity one
                resutlIntent.putExtra("result", result);
                setResult(RESULT_OK,resutlIntent);
                finish();
            }
        });

        //create btnSub listener
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1-number2;
                Intent resutlIntent = new Intent();
                resutlIntent.putExtra("result", result);
                setResult(RESULT_OK,resutlIntent);
                finish();
            }
        });
    }
}
