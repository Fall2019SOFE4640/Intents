/*
Auther : Anwar Abdalbari
Date: Sept. 23, 2019
Purpose: Intents
 */
package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtnum1;
    EditText txtnum2;
    static final int REQUEST_CODE = 1000;
    static final int REQUEST_CODE2= 1100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create two editText ref. variables to reference txtNumber1 & txtNumber2
        txtnum1 = (EditText) findViewById(R.id.txtNumber1);
        txtnum2 = (EditText) findViewById(R.id.txtNumber2);

        Button btnCallAct2 = (Button) findViewById(R.id.btnCallActivity2);

        //create a listner
        btnCallAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check the two numbers are inserted
               if(txtnum1.getText().toString().equals("") || txtnum2.getText().toString().equals("")) {
                   Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_LONG).show();
               }else{

                   //read num1 and num2
                   int num1 = Integer.parseInt(txtnum1.getText().toString());
                   int num2 = Integer.parseInt(txtnum2.getText().toString());

                    // create the intent
                   Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                   intent.putExtra("number1",num1);
                   intent.putExtra("number2",num2);
                   startActivityForResult(intent,REQUEST_CODE);
               }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == REQUEST_CODE && resultCode==RESULT_OK){
        int result = data.getIntExtra("result",0);
        TextView lblResult = (TextView)findViewById(R.id.lblResult);
        lblResult.setText(""+result);
    }
    }
}
