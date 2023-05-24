package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

public class Frutas extends AppCompatActivity {

    ImageButton botonNaranjas;



    AutoCompleteTextView auto;
    String[] frutas = {

            "Platanos", "Naranjas", "Fresas", "Mandarinas", "Uvas", "Manzanas"

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);

        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();


        // Esto se hace para que se autocomplete la entrada de texto

        auto = (AutoCompleteTextView) findViewById(R.id.txt_auto);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, frutas);
        auto.setThreshold(3); // Indicamos con cuántas letras empezará a autocompletar
        auto.setAdapter(adapter);

        // 1 Guardamos la referencia del botón de naranjas

        botonNaranjas = findViewById(R.id.boton_naranjas);

        botonNaranjas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Frutas.this,Muestrario.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });








    }
}