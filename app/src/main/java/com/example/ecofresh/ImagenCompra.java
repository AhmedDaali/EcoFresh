package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImagenCompra extends AppCompatActivity {

    Button botonComprar;

    Button botonRegresar;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_compra);

        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();

        // 1 Guardamos la referencia del botón de confirmar

        botonComprar = findViewById(R.id.boton_confirmar_compra);

        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ImagenCompra.this,UltimoPasoCompra.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });

        // 2 Guardamos la referencia del botón de regreso

        botonRegresar = findViewById(R.id.boton_regreso_imagen);

        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ImagenCompra.this,Muestrario.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });



    }
}