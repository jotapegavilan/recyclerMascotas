package com.gavilan.recyclerview_;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.ViewHolderDatos> {

    ArrayList<Mascota> listaMascotas;

    public MascotasAdapter(ArrayList<Mascota> listado){
            listaMascotas = listado;
    }

    @NonNull
    @Override
    public MascotasAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasAdapter.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listaMascotas.get(position));
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtNombre, txtEdad;
        Mascota mascota;
        public ViewHolderDatos(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtEdad = itemView.findViewById(R.id.txtEdad);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,mascota.getNombre()+" es un "+mascota.getTipo(),Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(view.getContext(), DetalleMascota.class);
                    // Enviar a la mascota en el intento
                    intent.putExtra("objetoMascota",mascota);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public void asignarDatos(Mascota m) {
            mascota = m;
            txtNombre.setText(m.getNombre());
            txtEdad.setText("Edad : "+m.getEdad()+" años.");
            if(m.getTipo().equals("perro")){
                Picasso.get().load(R.drawable.dog).into(imageView);
            }else{
                Picasso.get().load(R.drawable.cat).into(imageView);
            }

        }
    }
}
