package com.example.metalshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.metalshop.fragments.FragmentCamisetas;

public class MainActivity extends AppCompatActivity {
  private Button botonCamiseta;
  private   Button botonCD;
  private   Button botonParche;
  private Fragment fragment;
 private Fragment  fragmentC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCamiseta = findViewById(R.id.buttonCamisetas);
        botonCD = findViewById(R.id.buttonCD);

        botonCamiseta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new FragmentCamisetas();
                //Obtiene el Fragment manager
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.idMain,fragment).commit();
                botonCamiseta.setVisibility(View.GONE);
                botonCD.setVisibility(View.GONE);
                //agrega el Fragment en el contenedor, en este caso el FrameLayout con id `FrameLayout`.

            }
        });
        botonCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new FragmentCamisetas();
                //Obtiene el Fragment manager
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.idMain,fragment).commit();
                botonCamiseta.setVisibility(View.GONE);
                botonCD.setVisibility(View.GONE);
                //agrega el Fragment en el contenedor, en este caso el FrameLayout con id `FrameLayout`.
            }
        });

    }
}