package com.valentin.enfoques_trabajointegrador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Button btnBuscarPorId;
    private Button btnBuscarPorNombre;
    private Button btnFavoritos;
    private EditText txtBuscador;
    private ListView resultadoBusqueda;
    private Adaptador adapter;
    private List<Personaje> listaPersonajes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBuscador = findViewById(R.id.txt_buscador);
        btnFavoritos = findViewById(R.id.btn_favoritos);
        btnBuscarPorId = findViewById(R.id.btn_buscarPorId);
        btnBuscarPorNombre = findViewById(R.id.btn_buscarPorNombre);
        resultadoBusqueda = findViewById(R.id.resultado_busqueda);
        resultadoBusqueda.setOnItemClickListener(this);

        btnBuscarPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarPersonajePorId(txtBuscador.getText());
            }
        });

        btnBuscarPorNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarPersonajePorNombre(txtBuscador.getText());
            }
        });

        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                misFavoritos();
            }
        });

    }

    private void buscarPersonajePorId (final Editable id) {
        String url = "https://superheroapi.com/api/4764196856980399/" + id;

        StringRequest getRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    listaPersonajes.clear();
                    txtBuscador.getText().clear();

                    JSONObject jsonObject = new JSONObject(response);

                    InformacionPersonal datos = new InformacionPersonal(jsonObject.getJSONObject("appearance").getString("gender"), jsonObject.getJSONObject("appearance").getString("race"),
                            jsonObject.getJSONObject("appearance").getString("height"), jsonObject.getJSONObject("appearance").getString("weight"),jsonObject.getJSONObject("appearance").getString("eye-color"),
                            jsonObject.getJSONObject("appearance").getString("hair-color"), jsonObject.getJSONObject("work").getString("occupation"));

                    Powerstat powerstat = new Powerstat(jsonObject.getJSONObject("powerstats").getString("intelligence"), jsonObject.getJSONObject("powerstats").getString("strength"),
                            jsonObject.getJSONObject("powerstats").getString("speed"), jsonObject.getJSONObject("powerstats").getString("durability"),
                            jsonObject.getJSONObject("powerstats").getString("power"), jsonObject.getJSONObject("powerstats").getString("combat"));

                    Personaje personaje = new Personaje(jsonObject.getString("name"),jsonObject.getJSONObject("biography").getString("full-name"), jsonObject.getJSONObject("biography").getString("place-of-birth"),
                            jsonObject.getJSONObject("biography").getString("publisher"), powerstat, datos, jsonObject.getJSONObject("image").getString("url"), jsonObject.getString("id"));

                    listaPersonajes.add(personaje);

                    adapter = new Adaptador(MainActivity.this, R.layout.item_row, listaPersonajes);

                    resultadoBusqueda.setAdapter(adapter);

                } catch (JSONException e) {
                    //limpia la lista de personajes y luego actualiza el adapter
                    listaPersonajes.clear();
                    adapter = new Adaptador(MainActivity.this, R.layout.item_row, listaPersonajes);
                    resultadoBusqueda.setAdapter(adapter);

                    Toast.makeText(MainActivity.this, "Ingrese ID", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { Log.e("Error", error.getMessage()); }
        });
        Volley.newRequestQueue(this).add(getRequest);
    }

    private void buscarPersonajePorNombre (final Editable nombre) {
        String url = "https://superheroapi.com/api/4764196856980399/search/" + nombre;

        StringRequest getRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    listaPersonajes.clear();
                    txtBuscador.getText().clear();

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("results");

                    for (int i=0; i<array.length(); i++) {
                        JSONObject item = array.getJSONObject(i);

                        InformacionPersonal datos = new InformacionPersonal(item.getJSONObject("appearance").getString("gender"), item.getJSONObject("appearance").getString("race"),
                                item.getJSONObject("appearance").getString("height"), item.getJSONObject("appearance").getString("weight"),item.getJSONObject("appearance").getString("eye-color"),
                                item.getJSONObject("appearance").getString("hair-color"), item.getJSONObject("work").getString("occupation"));

                        Powerstat powerstat = new Powerstat(item.getJSONObject("powerstats").getString("intelligence"), item.getJSONObject("powerstats").getString("strength"),
                                item.getJSONObject("powerstats").getString("speed"), item.getJSONObject("powerstats").getString("durability"),
                                item.getJSONObject("powerstats").getString("power"), item.getJSONObject("powerstats").getString("combat"));

                        Personaje personaje = new Personaje(item.getString("name"),item.getJSONObject("biography").getString("full-name"),
                                item.getJSONObject("biography").getString("place-of-birth"), item.getJSONObject("biography").getString("publisher"), powerstat, datos,
                                item.getJSONObject("image").getString("url"), item.getString("id"));

                        listaPersonajes.add(personaje);
                    }

                    adapter = new Adaptador(MainActivity.this, R.layout.item_row, listaPersonajes);

                    resultadoBusqueda.setAdapter(adapter);

                } catch (JSONException e) {
                    //limpia la lista de personajes y luego actualiza el adapter
                    listaPersonajes.clear();
                    adapter = new Adaptador(MainActivity.this, R.layout.item_row, listaPersonajes);
                    resultadoBusqueda.setAdapter(adapter);

                    Toast.makeText(MainActivity.this, "Ingrese NOMBRE", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });

        Volley.newRequestQueue(this).add(getRequest);

    }

    public void misFavoritos () {

        Intent intent = new Intent(this, activity_misFavoritos.class);
        startActivity(intent);
    }

    //Click de los items de ListView
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        Intent intent = new Intent(this, activity_detallePersonaje.class);

        intent.putExtra("id_personaje", adapter.getItem(posicion).getId());
        intent.putExtra("personaje_imagen", adapter.getItem(posicion).getImg());
        intent.putExtra("personaje_nombrePersonaje", adapter.getItem(posicion).getNombre_personaje());
        intent.putExtra("personaje_nombreReal", adapter.getItem(posicion).getNombre_real());
        intent.putExtra("personaje_lugarNacimiento", adapter.getItem(posicion).getLugar_nacimiento());
        intent.putExtra("personaje_editorial", adapter.getItem(posicion).getEditorial());
        intent.putExtra("personaje_poder1", adapter.getItem(posicion).getPowestat().getIntelligence());
        intent.putExtra("personaje_poder2", adapter.getItem(posicion).getPowestat().getStrength());
        intent.putExtra("personaje_poder3", adapter.getItem(posicion).getPowestat().getSpeed());
        intent.putExtra("personaje_poder4", adapter.getItem(posicion).getPowestat().getDurability());
        intent.putExtra("personaje_poder5", adapter.getItem(posicion).getPowestat().getPower());
        intent.putExtra("personaje_poder6", adapter.getItem(posicion).getPowestat().getCombat());
        intent.putExtra("personaje_dato1", adapter.getItem(posicion).getInformacionPersonal().getGender());
        intent.putExtra("personaje_dato2", adapter.getItem(posicion).getInformacionPersonal().getRace());
        intent.putExtra("personaje_dato3", adapter.getItem(posicion).getInformacionPersonal().getHeight());
        intent.putExtra("personaje_dato4", adapter.getItem(posicion).getInformacionPersonal().getWeight());
        intent.putExtra("personaje_dato5", adapter.getItem(posicion).getInformacionPersonal().getEyesColor());
        intent.putExtra("personaje_dato6", adapter.getItem(posicion).getInformacionPersonal().getHairColor());
        intent.putExtra("personaje_dato7", adapter.getItem(posicion).getInformacionPersonal().getOccupation());

        //limpia la lista de personajes y luego actualiza el adapter
        listaPersonajes.clear();
        adapter = new Adaptador(MainActivity.this, R.layout.item_row, listaPersonajes);
        resultadoBusqueda.setAdapter(adapter);

        startActivity(intent);
    }

    //Se controla la salida de la APP apretando el boton de la barra del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de SUPERevil?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            builder.show();
        }

        return super.onKeyDown(keyCode, event);
    }
}