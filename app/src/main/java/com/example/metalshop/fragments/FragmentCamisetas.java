package com.example.metalshop.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.metalshop.CD;
import com.example.metalshop.Camisetas;
import com.example.metalshop.MiAdaptador;
import com.example.metalshop.Productos;
import com.example.metalshop.R;

import java.util.ArrayList;


public class FragmentCamisetas extends Fragment {

    View view;
    ArrayList<Productos> listaProductos = new ArrayList<>();
    RecyclerView recyclerView;


    public FragmentCamisetas() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_camisetas, container, false);
        recyclerView = vista.findViewById(R.id.idrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MiAdaptador miAdaptador = new MiAdaptador(getContext(),listaProductos,this);
        recyclerView.setAdapter(miAdaptador);

        listaProductos.add(new CD("Metallica", 10, 20, 60));
        listaProductos.add(new CD("Iron Maiden", 10, 20, 60));
        listaProductos.add(new CD("Slayer", 10, 20, 60));
        listaProductos.add(new Camisetas("Metallica", 10, 20, "L"));
        listaProductos.add(new Camisetas("Iron Maiden", 10, 20, "L"));
        listaProductos.add(new Camisetas("Slayer", 10, 20, "L"));

        return recyclerView;
    }
}