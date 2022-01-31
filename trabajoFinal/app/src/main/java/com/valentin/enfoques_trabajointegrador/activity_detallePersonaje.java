package com.valentin.enfoques_trabajointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class activity_detallePersonaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_personaje);

        ImageView btn_fav = (ImageView) findViewById(R.id.btn_fav);
        ImageView btn_share = (ImageView) findViewById(R.id.btn_share);

        TextView nombrePersonaje = findViewById(R.id.titulo_nombrePersonaje);
        ImageView imagen = findViewById(R.id.imagen_personaje);
        TextView nombreReal = findViewById(R.id.detalle_nombreReal);
        TextView lugarNacimiento = findViewById(R.id.detalle_lugarNacimiento);
        TextView editorial = findViewById(R.id.detalle_editorial);
        TextView poder1 = findViewById(R.id.detalle_poder1);
        TextView poder2 = findViewById(R.id.detalle_poder2);
        TextView poder3 = findViewById(R.id.detalle_poder3);
        TextView poder4 = findViewById(R.id.detalle_poder4);
        TextView poder5 = findViewById(R.id.detalle_poder5);
        TextView poder6 = findViewById(R.id.detalle_poder6);
        TextView dato1 = findViewById(R.id.detalle_dato1);
        TextView dato2 = findViewById(R.id.detalle_dato2);
        TextView dato3 = findViewById(R.id.detalle_dato3);
        TextView dato4 = findViewById(R.id.detalle_dato4);
        TextView dato5 = findViewById(R.id.detalle_dato5);
        TextView dato6 = findViewById(R.id.detalle_dato6);
        TextView dato7 = findViewById(R.id.detalle_dato7);

        Picasso.get().load(getIntent().getStringExtra("personaje_imagen")).into(imagen);
        nombrePersonaje.setText(getIntent().getStringExtra("personaje_nombrePersonaje"));
        nombreReal.setText("Nombre Real = " + getIntent().getStringExtra("personaje_nombreReal"));
        lugarNacimiento.setText("Lugar Nacimiento = " + getIntent().getStringExtra("personaje_lugarNacimiento"));
        editorial.setText("Editorial = " + getIntent().getStringExtra("personaje_editorial"));
        poder1.setText("Inteligencia = " + getIntent().getStringExtra("personaje_poder1"));
        poder2.setText("Fuerza = " + getIntent().getStringExtra("personaje_poder2"));
        poder3.setText("Velocidad = " + getIntent().getStringExtra("personaje_poder3"));
        poder4.setText("Durabilidad = " + getIntent().getStringExtra("personaje_poder4"));
        poder5.setText("Energia = " + getIntent().getStringExtra("personaje_poder5"));
        poder6.setText("Combate = " + getIntent().getStringExtra("personaje_poder6"));
        dato1.setText("Genero = " + getIntent().getStringExtra("personaje_dato1"));
        dato2.setText("Raza = " + getIntent().getStringExtra("personaje_dato2"));
        dato3.setText("Altura = " + getIntent().getStringExtra("personaje_dato3"));
        dato4.setText("Peso = " + getIntent().getStringExtra("personaje_dato4"));
        dato5.setText("Color ojos = " + getIntent().getStringExtra("personaje_dato5"));
        dato6.setText("Color cabello = " + getIntent().getStringExtra("personaje_dato6"));
        dato7.setText("Ocupacion = " + getIntent().getStringExtra("personaje_dato7"));

        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_detallePersonaje.this, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_detallePersonaje.this, "Se cliqeo btn Share", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
