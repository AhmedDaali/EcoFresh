package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Hortalizas extends AppCompatActivity {

    AutoCompleteTextView auto;
    String[] hortalizas = {

            "Zanahorias", "Patatas", "Tomates", "Ajos", "Cebollas", "Pimientos"

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hortalizas);




        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();


        // Esto se hace para que se autocomplete la entrada de texto

        auto = (AutoCompleteTextView) findViewById(R.id.txt_auto);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, hortalizas);
        auto.setThreshold(3); // Indicamos con cuántas letras empezará a autocompletar
        auto.setAdapter(adapter);
    }
}