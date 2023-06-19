package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.sax.RootElement;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {

    Button frag1,frag2,frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        frag1=findViewById(R.id.frag1);
        frag2=findViewById(R.id.frag2);
        frag3=findViewById(R.id.frag3);
        //default fragment
        loadFrag(new BFragment(),0);
        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new AFragment(),1);
            }
        });
        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new BFragment(),1);
            }
        });
        frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new AFragment(),1);
            }
        });
    }
    public void loadFrag(Fragment fragment,int flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag==0){
            ft.add(R.id.container,fragment);
        }else{
            ft.replace(R.id.container,fragment);
        }
        ft.addToBackStack(null);
        ft.commit();
    }
}