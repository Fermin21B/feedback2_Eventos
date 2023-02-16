package com.example.feedbackeventos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class camara extends AppCompatActivity {
    private Button btnCapture;
    private ImageView imgCapture;
    private static final int image_Capture_Code=1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camara_main);

        btnCapture = findViewById(R.id.btnTakePicture);
        imgCapture = findViewById(R.id.imgCapture);

        btnCapture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt,image_Capture_Code);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode==1 && resultCode ==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap)  extras.get("data");
            imgCapture.setImageBitmap(imgBitmap);
        }
    }
}
