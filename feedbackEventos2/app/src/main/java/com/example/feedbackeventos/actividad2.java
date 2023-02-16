package com.example.feedbackeventos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class actividad2 extends AppCompatActivity {
    private TextView nameLbl, resultLbl;
    private Button calculateBtn, returnBtn;
    private EditText binaryNumberTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2_screen);
        Log.v("segunda actividad page","segunda actividad loaded");

        setContentView(R.layout.activity_actividad2_screen);


        String name = getIntent().getStringExtra("welcome");
        nameLbl = findViewById(R.id.greetingDecimalLbl);
        nameLbl.setText(name);

        resultLbl = findViewById(R.id.resultDecimalLbl);

        binaryNumberTxt = findViewById(R.id.binaryNumberTxt);

        calculateBtn = findViewById(R.id.calcDecimalBtn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int binaryNumber = Integer.parseInt(binaryNumberTxt.getText().toString());
                    String result = Integer.toBinaryString(binaryNumber);

                    resultLbl.setText(getString(R.string.resultTxt).concat(result));

                } catch (Exception e) {
                    System.out.println(e.getCause());
                }
            }
        });

        returnBtn = findViewById(R.id.returnDecimalBtn);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}


