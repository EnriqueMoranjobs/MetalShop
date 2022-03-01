package com.example.metalshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CambiarContrasena extends AppCompatActivity {
    private Button botonVolver;
    private Button botonCambiarPass;
    String nombre;
    String oldPassword;
    String newPassword;
    String repeatPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasena);

        botonVolver = (Button) findViewById(R.id.btnVolver);
        botonCambiarPass = (Button) findViewById(R.id.btnCambiaPass);


        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CambiarContrasena.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        botonCambiarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = ((EditText) findViewById(R.id.idUserFragment)).getText().toString();
                oldPassword = ((EditText) findViewById(R.id.idOldPassword)).getText().toString();
                newPassword = ((EditText) findViewById(R.id.idNewPassword)).getText().toString();
                repeatPassword = ((EditText) findViewById(R.id.idRepeatPassword)).getText().toString();
                cambiarContrasena(nombre, oldPassword, newPassword, repeatPassword);
            }
        });
    }

    public void cambiarContrasena(String nombre, String oldPassword, String newPassword, String repeatPassword) {
        if (newPassword.equals(repeatPassword)) {
            DbUsuarios usuarios = new DbUsuarios(CambiarContrasena.this);
            Usuario recuperaUsuario = usuarios.consultarUsuario(nombre);
            if (recuperaUsuario != null) {
                if (oldPassword.equals(recuperaUsuario.getContrasena())) {
                    SQLiteDatabase bd = usuarios.getWritableDatabase();
                    String updateQuery = ("UPDATE usuarios SET contrasenia = '" + newPassword + "' where nombre ='" + nombre + "'");
                    bd.execSQL(updateQuery);
                } else {
                    Toast.makeText(this, "La contraseña antigua no es correcta", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "La nueva contraseña no coincide", Toast.LENGTH_SHORT).show();
        }


    }
}