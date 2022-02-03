package com.valentin.enfoques_trabajointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class activity_popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        DisplayMetrics medidasPopup = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasPopup);

        int ancho = medidasPopup.widthPixels;
        int alto = medidasPopup.heightPixels;

        getWindow().setLayout((int)(ancho * 0.85), (int)(alto * 0.5));

        TextView detalle = findViewById(R.id.txt_detallePersonaje);

        detalle.setText(getIntent().getStringExtra("detalle_personaje"));

    }
}