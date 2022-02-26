package com.example.metalshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//    Glide for loading girls
        ImageView mHand = findViewById(R.id.fondohand);

        Glide.with(this)
                .load(R.drawable.hand)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .into(mHand);
    }

    // Method for Vaccinate button
    public void openMain(View v) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openAdmin(View v) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

}

