package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight, editHeightFt, editHeightIn;
        Button calculatorButton, btnNext;
        TextView txtResult;
        LinearLayout linearMain;

        editWeight = findViewById(R.id.editWeight);
        editHeightIn = findViewById(R.id.editHeightIn);
        editHeightFt = findViewById(R.id.editHeightFt);
        calculatorButton = findViewById(R.id.calculatorButton);
        txtResult = findViewById(R.id.txtResult);
        linearMain = findViewById(R.id.linearMain);
        btnNext = findViewById(R.id.btnNext);
        Log.w("Test", "Warning Log");
        //database
//        MyDBHelper dbHelper=new MyDBHelper(this);
//        dbHelper.addContact("Anirudha","6296582411");
//        dbHelper.addContact("Ram","9564303139");
//

        //shared preferences
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
//                Boolean check = pref.getBoolean("flag", false);
//                Intent iNext;
//                if (check) {
//                    iNext = new Intent(MainActivity.this, ToolBarActivity.class);
//
//                } else {
//                    iNext = new Intent(MainActivity.this, RecycleActivity.class);
//
//                }
//                startActivity(iNext);
//            }
//        },4000);

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int wt= Integer.parseInt(editWeight.getText().toString());
              int in= Integer.parseInt(editHeightIn.getText().toString());
              int ft=Integer.parseInt(editHeightFt.getText().toString());

              int totalIn=ft*12 +in;
              double totalCm=totalIn*2.53;
              double totalM=totalCm/100;

              double bmi=wt/(totalM*totalM);
              if(bmi>25){
                  txtResult.setText("You are Overweight");
                  linearMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
              }else if(bmi<18){
                  txtResult.setText("You are Underweight");
                  linearMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
              }else{
                  txtResult.setText("You are Healthy");
                  linearMain.setBackgroundColor(getResources().getColor(R.color.colorHlt));
              }
            }
        });
        Intent iNext;
        iNext=new Intent(MainActivity.this,SecondActivity.class);
        iNext.putExtra("title","Home");
        iNext.putExtra("Roll",20);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iNext);
            }
        });



    }
}