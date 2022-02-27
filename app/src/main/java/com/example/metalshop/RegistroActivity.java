package com.example.metalshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    private Button botonCrear;
    private DatabaseHelper basedatos;
    private EditText etUsername, etpass, etmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        basedatos = new DatabaseHelper(RegistroActivity.this);

        botonCrear = (Button) findViewById(R.id.btnCrear);
        etUsername = (EditText) findViewById(R.id.idUser);
        etpass = (EditText) findViewById(R.id.idPassword);
        etmail = (EditText) findViewById(R.id.idEmail);

        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNombreUsuario = etUsername.getText().toString();
                String getContraseña = etpass.getText().toString();
                String getEmail = etmail.getText().toString();

                DbUsuarios dbUsuarios = new DbUsuarios(RegistroActivity.this);
                long id = dbUsuarios.insertarUsuario(getNombreUsuario, getContraseña);

                if (id > 0) {
                    Toast.makeText(RegistroActivity.this, "Registro completado", Toast.LENGTH_LONG).show();
                    limpiar();
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegistroActivity.this, "Error al registrarse", Toast.LENGTH_LONG).show();
                }
            }




    });

    }

    private void limpiar() {

        etUsername.setText("");
        etpass.setText("");
    }
}
