package com.valentin.enfoques_trabajointegrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
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
        TextView txt_detalle = findViewById(R.id.txt_detalle);

        TextView nombrePersonaje = findViewById(R.id.titulo_nombrePersonaje);
        ImageView imagen = findViewById(R.id.imagen_personaje);

        String descripcion = "¿Que tal? Te habla " + getIntent().getStringExtra("personaje_nombrePersonaje") +
                ", aunque algunos tambien me conocen por " + getIntent().getStringExtra("personaje_nombreReal") + ". Naci en " + getIntent().getStringExtra("personaje_lugarNacimiento") +
                " pero quien realmente me dio vida fue la Editorial " + getIntent().getStringExtra("personaje_editorial") + ". Paso mi tiempo trabajando como " + getIntent().getStringExtra("personaje_dato7") + ". Para que sepas un poco mas acerca de mis poderes, puedo contarte que tengo "
                + getIntent().getStringExtra("personaje_poder1") + "% de Inteligencia, " + getIntent().getStringExtra("personaje_poder2") + "% de Fuerza, " + getIntent().getStringExtra("personaje_poder3")
                + "% de Velocidad, " + getIntent().getStringExtra("personaje_poder4") + "% de Durabilidad, " + getIntent().getStringExtra("personaje_poder5") + "% de Energia, "
                + getIntent().getStringExtra("personaje_poder6") + "% de Combate. Dudo que no me hayas visto, pero en el caso de que eso no haya pasado, por si algun dia me cruzas te cuento mi genero es " +
                getIntent().getStringExtra("personaje_dato1") + ", mi raza es " + getIntent().getStringExtra("personaje_dato2") + ", mido " + getIntent().getStringExtra("personaje_dato3") +
                ", mi peso es " + getIntent().getStringExtra("personaje_dato4") + ", tengo unos ojos color " + getIntent().getStringExtra("personaje_dato5") + " y cabello color " +
                getIntent().getStringExtra("personaje_dato6") + ".";

        txt_detalle.setText(descripcion);

        nombrePersonaje.setText(getIntent().getStringExtra("personaje_nombrePersonaje"));

        Picasso.get().load(getIntent().getStringExtra("personaje_imagen")).into(imagen);

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
                } else{
                    Toast.makeText(activity_detallePersonaje.this, "Ya forma parte de tus personajes favoritos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Funcion del boton de compartir
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String share = "¿Que tal? Te habla " + getIntent().getStringExtra("personaje_nombrePersonaje") +
                        ", aunque algunos tambien me conocen por " + getIntent().getStringExtra("personaje_nombreReal") + ". Naci en " + getIntent().getStringExtra("personaje_lugarNacimiento") +
                        " pero quien realmente me dio vida fue la Editorial " + getIntent().getStringExtra("personaje_editorial") + ". Paso mi tiempo trabajando como " + getIntent().getStringExtra("personaje_dato7") + ". Para que sepas un poco mas acerca de mis poderes, puedo contarte que tengo "
                        + getIntent().getStringExtra("personaje_poder1") + "% de Inteligencia, " + getIntent().getStringExtra("personaje_poder2") + "% de Fuerza, " + getIntent().getStringExtra("personaje_poder3")
                        + "% de Velocidad, " + getIntent().getStringExtra("personaje_poder4") + "% de Durabilidad, " + getIntent().getStringExtra("personaje_poder5") + "% de Energia, "
                        + getIntent().getStringExtra("personaje_poder6") + "% de Combate. Dudo que no me hayas visto, pero en el caso de que eso no haya pasado, por si algun dia me cruzas te cuento mi genero es " +
                        getIntent().getStringExtra("personaje_dato1") + ", mi raza es " + getIntent().getStringExtra("personaje_dato2") + ", mido " + getIntent().getStringExtra("personaje_dato3") +
                        ", mi peso es " + getIntent().getStringExtra("personaje_dato4") + ", tengo unos ojos color " + getIntent().getStringExtra("personaje_dato5") + " y cabello color " +
                        getIntent().getStringExtra("personaje_dato6") + ". Simplemente pasaba a comentarte que si no lo has hecho aun, no dudes en descargarte SUPERevil para conocer a todos los personajes del mundo" +
                        " de los comics, asi como lo has hecho conmigo.";

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, share);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });    }
}
