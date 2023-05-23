package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

public class Selection extends AppCompatActivity {

    ImageButton botonFrutas;
    ImageButton botonVerduras;
    ImageButton botonLegumbres;
    ImageButton botonHortalizas;
    // Esto es el código para la entrada de texto autocompletable

    AutoCompleteTextView auto;
    String[] productos = {

       "Frutas", "Verduras", "Hortalizas", "Legumbres"

    };




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();


        // Esto se hace para que se autocomplete la entrada de texto

        auto = (AutoCompleteTextView) findViewById(R.id.txt_auto);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, productos);
        auto.setThreshold(3); // Indicamos con cuántas letras empezará a autocompletar
        auto.setAdapter(adapter);


        // Guardamos la referencia del botón de frutas

        botonFrutas = findViewById(R.id.boton_fruta);

        botonFrutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Selection.this,Frutas.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });

    }
}