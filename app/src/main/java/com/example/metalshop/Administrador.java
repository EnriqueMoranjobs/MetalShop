package com.example.metalshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Administrador extends AppCompatActivity {
    private MiAdaptador adapter;
    ArrayList<Productos> listaProductos = new ArrayList<>();

    RecyclerView recyclerView;
    EditText input;
    TextView output;
    Productos itemProducto;
    boolean vip = false;
    Switch swVip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        listaProductos.add(new CD("Metallica", 10, 20, 60));
        listaProductos.add(new CD("Iron Maiden", 10, 20, 60));
        listaProductos.add(new CD("Slayer", 10, 20, 60));
        listaProductos.add(new Camisetas("Metallica", 10, 20, "L"));
        listaProductos.add(new Camisetas("Iron Maiden", 10, 20, "L"));
        listaProductos.add(new Camisetas("Slayer", 10, 20, "L"));


        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
        adapter = new MiAdaptador(this, listaProductos);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                mLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);


    }

}
