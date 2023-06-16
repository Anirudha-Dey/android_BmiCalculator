package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent formAct=getIntent();
        String title=formAct.getStringExtra("title");
        int rollNo=formAct.getIntExtra("Roll",0);

        ArrayList<String> arrNames=new ArrayList<>();
        TextView txtView;
        Button btnTranslate,nextBtn,nextTool;
        ListView listView;
        Spinner spinner;
        AutoCompleteTextView autoType;
        autoType=findViewById(R.id.autoType);
        spinner=findViewById(R.id.spinner);
        listView=findViewById(R.id.listView);
        btnTranslate=findViewById(R.id.btnTranslate);
        nextBtn=findViewById(R.id.nextBtn);
        nextTool=findViewById(R.id.nextTool);
        txtView=findViewById(R.id.txtView);
        txtView.setText("Title "+title+" Roll No= "+rollNo);


        arrNames.add("Anirudha");
        arrNames.add("Sougata");
        arrNames.add("Pritam");
        arrNames.add("Suman");
        arrNames.add("jahangir");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNext;
                iNext=new Intent(SecondActivity.this,RecycleActivity.class);
                startActivity(iNext);
            }
        });
        nextTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNext;
                iNext=new Intent(SecondActivity.this,ToolBarActivity.class);
                startActivity(iNext);
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrNames);
        ArrayAdapter<String> autoCompleteAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);
        spinner.setAdapter(spinnerAdapter);
        autoType.setAdapter(autoCompleteAdapter);
        autoType.setThreshold(1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"Clicked "+position+" Item",Toast.LENGTH_SHORT).show();


            }
        });
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
                txtView.startAnimation(translate);
            }
        });
        Dialog d=new Dialog(this);
        d.setContentView(R.layout.custom_toast_layout);
        d.show();



    }
}