package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmCompra extends AppCompatActivity {

    Button botonContinuarCompra;
    Button botonExit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_compra);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();


        // 1 Boton para regresar a la activity_selection

        botonContinuarCompra = findViewById(R.id.btnContinuarComprando);

        botonContinuarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfirmCompra.this,Selection.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });

        // 2 Boton para salir

        botonExit = findViewById(R.id.exit);

        botonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfirmCompra.this,Inicial.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });





    }
}