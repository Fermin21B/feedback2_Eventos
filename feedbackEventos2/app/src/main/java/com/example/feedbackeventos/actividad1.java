package com.example.feedbackeventos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1_page);
        Log.v("actividad1","actividad1 loaded");




    }

    public void launchactividad12(View view) {
        Toast.makeText(actividad1.this, "REGISTRO CORRECTO", Toast.LENGTH_SHORT).show();
    }
}
