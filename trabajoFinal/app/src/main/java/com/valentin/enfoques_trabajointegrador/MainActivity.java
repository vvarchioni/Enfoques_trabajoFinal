package com.valentin.enfoques_trabajointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
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
    private EditText txtBuscador;
    private ListView resultadoBusqueda;
    private Adaptador adapter;
    private List<Personaje> listaPersonajes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBuscador = findViewById(R.id.txt_buscador);
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
                    Personaje personaje = new Personaje(jsonObject.getString("name"),jsonObject.getJSONObject("biography").getString("full-name"), " null ", jsonObject.getJSONObject("biography").getString("publisher")," null ", " null ", jsonObject.getJSONObject("image").getString("url"), jsonObject.getString("id"));
                    //Log.d ("my_tag2", personaje.toString());

                    listaPersonajes.add(personaje);

                    adapter = new Adaptador(MainActivity.this, R.layout.item_row, listaPersonajes);

                    resultadoBusqueda.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
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
                    //Log.d("my_tag", array.toString());
                    //Log.d("my_tag_size", String.valueOf(array.length()));

                    for (int i=0; i<array.length(); i++) {
                        JSONObject item = array.getJSONObject(i);
                        Personaje personaje = new Personaje(item.getString("name"),item.getJSONObject("biography").getString("full-name"), " null ", item.getJSONObject("biography").getString("publisher")," null ", " null ", item.getJSONObject("image").getString("url"), item.getString("id"));
                        //Log.d ("my_tag_personaje", personaje.toString());

                        listaPersonajes.add(personaje);
                    }



                    adapter = new Adaptador(MainActivity.this, R.layout.item_row, listaPersonajes);

                    resultadoBusqueda.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
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


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        //Toast.makeText(this, "Se clickeo elemento " + posicion, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, activity_detallePersonaje.class);
        intent.putExtra("personaje_imagen", adapter.getItem(posicion).getImg());
        intent.putExtra("personaje_nombrePersonaje", adapter.getItem(posicion).getNombre_personaje());
        intent.putExtra("personaje_nombreReal", adapter.getItem(posicion).getNombre_real());
        intent.putExtra("personaje_lugarNacimiento", adapter.getItem(posicion).getLugar_nacimiento());
        intent.putExtra("personaje_editorial", adapter.getItem(posicion).getEditorial());
        intent.putExtra("personaje_poderes", adapter.getItem(posicion).getPoderes());
        intent.putExtra("personaje_datos", adapter.getItem(posicion).getDatos());
        startActivity(intent);
    }
}