package com.gavilan.recyclerview_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerMascotas);


        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(1,"Tom","gato",3));
        mascotas.add(new Mascota(2,"Kimbo","perro",4));
        mascotas.add(new Mascota(3,"Tomy","gato",2));
        mascotas.add(new Mascota(4,"Bimbo","perro",1));
        mascotas.add(new Mascota(5,"Tom","gato",3));
        mascotas.add(new Mascota(6,"Kimbo","perro",4));
        mascotas.add(new Mascota(7,"Tomy","gato",2));
        mascotas.add(new Mascota(8,"Bimbo","perro",1));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MascotasAdapter adaptador = new MascotasAdapter(mascotas);

        recyclerView.setAdapter(adaptador);


    }
}