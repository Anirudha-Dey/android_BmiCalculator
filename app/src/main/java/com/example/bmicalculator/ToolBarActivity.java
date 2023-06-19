package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        Button btnDial,btnCameraOpen,btnFragment;
        Toolbar toolBar;
        WebView webView;
        webView=findViewById(R.id.webView);
        toolBar=findViewById(R.id.toolBar);
        btnDial=findViewById(R.id.btnDial);
        btnFragment=findViewById(R.id.btnFragment);
        btnCameraOpen=findViewById(R.id.btnCameraOpen);
        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNext;
                iNext=new Intent(Intent.ACTION_DIAL);
                iNext.setData(Uri.parse("tel: +916296582411"));
                startActivity(iNext);
            }
        });

        btnCameraOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCameraBtn;
                iCameraBtn=new Intent(ToolBarActivity.this,Camera.class);
                startActivity(iCameraBtn);
            }
        });

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iFrag;
                iFrag=new Intent(ToolBarActivity.this,FragmentActivity.class);
                startActivity(iFrag);
            }
        });


        //step-1
        setSupportActionBar(toolBar);

        //step-2
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Welcome User");
        }

        toolBar.setSubtitle("SubTitle");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.opt_new){
            Toast toast=new Toast(getApplicationContext());
            View view=getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.viewContainer));
            toast.setView(view);
            TextView cusToast=view.findViewById(R.id.cusToast);
            cusToast.setText("New File Create Successfully");
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
            //Toast.makeText(this,"Create New File",Toast.LENGTH_SHORT).show();
        }else if(itemId==R.id.opt_open){
            Toast.makeText(this,"File Open",Toast.LENGTH_SHORT).show();
        }else if(itemId==R.id.opt_save){

            AlertDialog alertBox=new AlertDialog.Builder(ToolBarActivity.this).create();
            alertBox.setTitle("Term & Condition");
            alertBox.setIcon(R.drawable.baseline_question_mark_24);
            alertBox.setMessage("Have you read all term & conditions");

            alertBox.show();
            Toast.makeText(this,"File Saved",Toast.LENGTH_SHORT).show();

        }else{
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}