package com.example.feedbackeventos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("title");
        Log.v("landing page","landing page loaded");


        Button firstact=findViewById(R.id.actividad1);
        firstact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("landing page","actividad1 hit");
                Intent inten=new Intent(MainActivity.this, actividad1.class);
                try {
                    startActivity(inten);
                }catch (Exception e){
                    System.out.println(e);
                    Log.e("landing page","actividad1 button failed");
                }

            }
        });

        Button seconact=findViewById(R.id.actividad2);
        seconact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("landing page","actividad2 button hit");
                Intent intent=new Intent(MainActivity.this, actividad2.class);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    System.out.println(e);
                    Log.e("landing page","actividad2 button failed");
                }
            }
        });

        Button acti3=findViewById(R.id.actividad3);
        acti3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("landing page","actividad3 button hit");
                Intent intent=new Intent(MainActivity.this, actividad3.class);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    System.out.println(e);
                    Log.e("landing page","actividad3 button failed");
                }
            }
        });

        Button campusMapButton=findViewById(R.id.MapaCampus);
        campusMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("landing page","campus map button hit");
                Intent intent=new Intent(MainActivity.this,campusMap.class);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    System.out.println(e);
                    Log.e("landing page","campus button failed");
                }
            }
        });
        Button fivebutton=findViewById(R.id.actividad5);
        fivebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("landing page","DrawerActivity button hit");
                Intent intent=new Intent(MainActivity.this, DrawerActivity.class);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    System.out.println(e);
                    Log.e("landing page","DrawerActivity button failed");
                }
            }
        });

        Button buttonsix=findViewById(R.id.webview);
        buttonsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("landing page","webview button hit");
                Intent intent=new Intent(MainActivity.this, actividad6.class);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    System.out.println(e);
                    Log.e("landing page","webview button failed");
                }
            }
        });
        Button cam=findViewById(R.id.camara);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("landing page","cam button hit");
                Intent intent=new Intent(MainActivity.this, camara.class);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    System.out.println(e);
                    Log.e("landing page","cam button failed");
                }
            }
        });

        Button aboutButton=findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("landing page","about button hit");
                Intent intent=new Intent(MainActivity.this, aboutMe.class);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    System.out.println(e);
                    Log.e("landing page","about button failed");
                }
            }
        });

        ImageView imageView=findViewById(R.id.WestHallImage);

        //Drawable d=getDrawable()

      //  imageView.setImageDrawable(R.drawable.campusmap);


    }




}
