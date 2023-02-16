package com.example.feedbackeventos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class actividad3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3_screen);
        Log.v("tercera actividad page", "tercera actividad loaded");
    }
        public void irContactos (View view){
            Intent intentContactos = new Intent(Intent.ACTION_DIAL);
            startActivity(intentContactos);
        }

        public void llamar (View view){
            EditText phone = findViewById(R.id.numTelf);
            String num =  phone.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", num, null));
            startActivity(intent);
    }
}
