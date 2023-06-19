package com.example.bmicalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    private static final int Camera_Req_Code=100;
    private static final int Gallary_Req_Code=1000;
    ImageView imgCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imgCamera=findViewById(R.id.imgCamera);
        Button btnCamera=findViewById(R.id.btnCamera);
        Button btnGallary=findViewById(R.id.btnGallary);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera,Camera_Req_Code);
            }
        });

        btnGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGallary=new Intent(Intent.ACTION_PICK);
                iGallary.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallary,Gallary_Req_Code);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==Camera_Req_Code){
                Bitmap img=(Bitmap) data.getExtras().get("data");
                imgCamera.setImageBitmap(img);
            }
            else if(requestCode==Gallary_Req_Code){
                imgCamera.setImageURI(data.getData());
            }
        }
    }
}