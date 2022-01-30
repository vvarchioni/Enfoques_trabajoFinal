package com.valentin.enfoques_trabajointegrador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends ArrayAdapter<Personaje> {

    private List<Personaje> listaPersonajes;
    private Context contexto;
    private int resourceLayout;

    public Adaptador(@NonNull Context context, int resource, List<Personaje> objects) {
        super(context, resource, objects);
        this.listaPersonajes = objects;
        this.contexto = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(contexto).inflate(resourceLayout, null);

        Personaje per = listaPersonajes.get(position);

        ImageView img_imagenPersonaje = view.findViewById(R.id.imagen_personaje);
        Picasso.get().load(per.getImg()).into(img_imagenPersonaje);

        TextView txt_nombrePersonaje = view.findViewById(R.id.nombre_personaje);
        txt_nombrePersonaje.setText(per.getNombre_personaje());

        TextView txt_nombreReal = view.findViewById(R.id.nombre_real);
        txt_nombreReal.setText(per.getNombre_real());

        TextView txt_id = view.findViewById(R.id.id_personaje);
        txt_id.setText(per.getId());

        return view;


    }
}
