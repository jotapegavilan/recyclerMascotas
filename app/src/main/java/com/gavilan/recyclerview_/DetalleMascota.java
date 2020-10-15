package com.gavilan.recyclerview_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleMascota extends AppCompatActivity {

    private TextView nombre,edad,descripcion;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);
        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        descripcion = findViewById(R.id.descripcion);
        imagen = findViewById(R.id.imagen);

        // obtener el intento
        Intent intent = getIntent();
        // del intento hay que obtener los extras(datos)
        Bundle bundle = intent.getExtras();
        // del bundle hay que sacar la mascota que se envío utilizando el name
        // con el que se envío el objeto
        Mascota mascota = (Mascota) bundle.get("objetoMascota");

        nombre.setText(mascota.getNombre());
        edad.setText("La edad de la mascota es de "+mascota.getEdad()+" años.");
        descripcion.setText("Esta mascota es de tipo : "+mascota.getTipo());
        if(mascota.getTipo().equals("perro")){
            Picasso.get().load(R.drawable.dog).into(imagen);
        }else{
            Picasso.get().load(R.drawable.cat).into(imagen);
        }

    }
}