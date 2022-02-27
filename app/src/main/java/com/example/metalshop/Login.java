package com.example.metalshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.text.BreakIterator;

public class Login extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener {

    private Button botonEntrar;

    private Button botonSinCuenta;

    private DatabaseHelper basedatos;

    private EditText etUsername, etpass;
    private CheckBox rememberCheckbox;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        basedatos = new DatabaseHelper(Login.this);

        botonEntrar = (Button) findViewById(R.id.btnEntrar);
        botonSinCuenta = (Button) findViewById(R.id.btnSinCuenta);

        etUsername = (EditText) findViewById(R.id.idUser);
        etpass = (EditText) findViewById(R.id.idPassword);

        botonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNombreUsuario = etUsername.getText().toString();
                String getContraseña = etpass.getText().toString();

                DbUsuarios dbUsuarios = new DbUsuarios(Login.this);
                Cursor cursor = dbUsuarios.consultarUsuario(getNombreUsuario, getContraseña);
                if (cursor.getCount() > 0) {
                    Toast.makeText(Login.this, "Bienvenido", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                    limpiar();
                } else {
                    Toast.makeText(Login.this, "Error en el login", Toast.LENGTH_LONG).show();
                }

            }

        });


        sharedPreferences =

                getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();
        etUsername =

                findViewById(R.id.idUser);

        etpass =

                findViewById(R.id.idPassword);

        rememberCheckbox =

                findViewById(R.id.checkBox);

        if (sharedPreferences.getBoolean(KEY_REMEMBER, false))
            rememberCheckbox.setChecked(true);
        else
            rememberCheckbox.setChecked(false);

        etUsername.setText(sharedPreferences.getString(KEY_USERNAME, ""));
        etpass.addTextChangedListener(this);
        rememberCheckbox.setOnCheckedChangeListener(this);
    }


    private void limpiar() {

        etUsername.setText("");
        etpass.setText("");
    }

//
    public void crearCuenta(View v) {
        Intent intent = new Intent(Login.this, RegistroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openAdmin(View v) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        managePrefs();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        managePrefs();
    }

    private void managePrefs() {
        if (rememberCheckbox.isChecked()) {
            editor.putString(KEY_USERNAME, etUsername.getText().toString().trim());
            editor.putString(KEY_PASS, etpass.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();
        } else {
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_PASS);
            editor.remove(KEY_USERNAME);
            editor.apply();
        }
    }
}


