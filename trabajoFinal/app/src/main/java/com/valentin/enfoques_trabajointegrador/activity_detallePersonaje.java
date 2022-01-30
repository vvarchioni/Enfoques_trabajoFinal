package com.valentin.enfoques_trabajointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class activity_detallePersonaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_personaje);

        TextView nombrePersonaje = findViewById(R.id.titulo_nombrePersonaje);
        ImageView imagen = findViewById(R.id.imagen_personaje);
        TextView nombreReal = findViewById(R.id.detalle_nombreReal);
        TextView lugarNacimiento = findViewById(R.id.detalle_lugarNacimiento);
        TextView editorial = findViewById(R.id.detalle_editorial);
        TextView poderes = findViewById(R.id.detalle_poderes);
        TextView datos = findViewById(R.id.detalle_datos);

        Picasso.get().load(getIntent().getStringExtra("personaje_imagen")).into(imagen);
        nombrePersonaje.setText(getIntent().getStringExtra("personaje_nombrePersonaje"));
        nombreReal.setText(getIntent().getStringExtra("personaje_nombreReal"));
        lugarNacimiento.setText(getIntent().getStringExtra("personaje_lugarNacimiento"));
        editorial.setText(getIntent().getStringExtra("personaje_editorial"));
        poderes.setText(getIntent().getStringExtra("personaje_poderes"));
        datos.setText(getIntent().getStringExtra("personaje_datos"));
    }
}