package com.valentin.enfoques_trabajointegrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.valentin.enfoques_trabajointegrador.Config.Constantes;

public class activity_detallePersonaje extends AppCompatActivity {

    AppDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_personaje);

        Button btn_fav = findViewById(R.id.btn_fav);
        Button btn_share = findViewById(R.id.btn_share);

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

        nombrePersonaje.setText(getIntent().getStringExtra("personaje_nombrePersonaje"));

        Picasso.get().load(getIntent().getStringExtra("personaje_imagen")).into(imagen);

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

        //Funcion del boton de favoritos
        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = Room.databaseBuilder(getApplicationContext(),AppDataBase.class, Constantes.BD_NAME)
                        .allowMainThreadQueries()
                        .build();

                Entity_Personaje per = db.personajeDAO().exist(getIntent().getStringExtra("id_personaje"));

                if (per == null) {
                    Entity_Personaje personaje = new Entity_Personaje(getIntent().getStringExtra("id_personaje"), getIntent().getStringExtra("personaje_nombrePersonaje"),
                            getIntent().getStringExtra("personaje_nombreReal"), getIntent().getStringExtra("personaje_lugarNacimiento"),
                            getIntent().getStringExtra("personaje_editorial"), getIntent().getStringExtra("personaje_poder1"), getIntent().getStringExtra("personaje_poder2"),
                            getIntent().getStringExtra("personaje_poder3"), getIntent().getStringExtra("personaje_poder4"), getIntent().getStringExtra("personaje_poder5"),
                            getIntent().getStringExtra("personaje_poder6"), getIntent().getStringExtra("personaje_dato1"), getIntent().getStringExtra("personaje_dato2"),
                            getIntent().getStringExtra("personaje_dato3"), getIntent().getStringExtra("personaje_dato4"), getIntent().getStringExtra("personaje_dato5"),
                            getIntent().getStringExtra("personaje_dato6"), getIntent().getStringExtra("personaje_dato7"), getIntent().getStringExtra("personaje_imagen"));

                    db.personajeDAO().insert(personaje);

                    Toast.makeText(activity_detallePersonaje.this, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(activity_detallePersonaje.this, "Ya forma parte de tus personajes favoritos", Toast.LENGTH_SHORT).show();

            }
        });

        //Funcion del boton de compartir
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "¿Que tal? Por si no sabes quien soy, te habla " + getIntent().getStringExtra("personaje_nombrePersonaje") +
                        ". Queria invitarte a descargarte la app SUPERevil, ¡donde conoceras la informacion de todos los personajes del mundo de los Comics!");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

    }
}
