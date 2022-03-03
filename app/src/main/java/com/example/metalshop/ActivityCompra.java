package com.example.metalshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCompra extends AppCompatActivity {
   private TextView textView;
   private Button buttonC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        textView = findViewById(R.id.tvCompra);



        String nombre = getIntent().getStringExtra("idName");


        textView.setText(nombre);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(" ");
                Toast.makeText(ActivityCompra.this, "Gracias por su compra!", Toast.LENGTH_LONG).show();
            }
        });






    }
}