package com.valentin.enfoques_trabajointegrador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.valentin.enfoques_trabajointegrador.Config.Constantes;

import java.util.ArrayList;
import java.util.List;

public class activity_misFavoritos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    AppDataBase db;

    private ListView listaFavoritos;
    private Adaptador_MisFavoritos adapter;
    private List<Entity_Personaje> listaPersonajes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_favoritos);

        listaFavoritos = findViewById(R.id.list_favs);
        listaFavoritos.setOnItemClickListener(this);

        db = Room.databaseBuilder(getApplicationContext(),AppDataBase.class, Constantes.BD_NAME)
                .allowMainThreadQueries()
                .build();

        listaPersonajes = db.personajeDAO().getMyFavorites();

        adapter = new Adaptador_MisFavoritos(this, R.layout.item_row, listaPersonajes);

        listaFavoritos.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Toast.makeText(this, "AAAA", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity_misFavoritos.this);
        alerta.setMessage("¿Desea desmarcar a " + adapter.getItem(position).getNombre_personaje() +
                " como favorito?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.personajeDAO().delete(adapter.getItem(position).getId_personaje());

                        listaPersonajes = db.personajeDAO().getMyFavorites();
                        adapter = new Adaptador_MisFavoritos(activity_misFavoritos.this, R.layout.item_row, listaPersonajes);
                        listaFavoritos.setAdapter(adapter);

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog titulo = alerta.create();
        titulo.setTitle("Desmarcar Favorito");
        titulo.show();
    }
}