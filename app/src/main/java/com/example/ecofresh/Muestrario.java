package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Muestrario extends AppCompatActivity {

    Button botonRegreso;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestrario);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();

        // 1 Guardamos la referencia del botón de regreso

        botonRegreso = findViewById(R.id.volver);

        botonRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Muestrario.this,UltimoPasoCompra.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });



    }
}