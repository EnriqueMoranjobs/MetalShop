package com.example.metalshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityCompra extends AppCompatActivity {
    TextView textView;
    String info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        textView = findViewById(R.id.tvCompra);


        String nombre = getIntent().getStringExtra("idData");

        textView.setText(nombre);



    }
}