package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Venta extends AppCompatActivity {


    // Esto es el código para la entrada de texto autocompletable

    AutoCompleteTextView autoCategoria;
    String[] categorias = {

            "Frutas", "Verduras", "Hortalizas", "Legumbres"

    };


    AutoCompleteTextView autoProductos;
    String[] productos = {

            "Manzana", "Naranja", "Plátanos", "Uvas", "Espinacas", "Col"

    };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();


        // Esto se hace para que se autocomplete la entrada de texto de la categoría

        autoCategoria = (AutoCompleteTextView) findViewById(R.id.text_auto);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, categorias);
        autoCategoria.setThreshold(3); // Indicamos con cuántas letras empezará a autocompletar
        autoCategoria.setAdapter(adapter);


        // Esto se hace para que se autocomplete la entrada de texto de los productos

        autoProductos = (AutoCompleteTextView) findViewById(R.id.txt2_auto);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, productos);
        autoProductos.setThreshold(3); // Indicamos con cuántas letras empezará a autocompletar
        autoProductos.setAdapter(adapter2);






    }
}