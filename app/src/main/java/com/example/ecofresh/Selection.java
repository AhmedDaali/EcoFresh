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

    private Button botonMenu;

    private ImageButton botonFrutas;
    private ImageButton botonVerduras;
    private ImageButton botonLegumbres;
    private ImageButton botonHortalizas;



    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();



        // 1 Guardamos la referencia del botón de frutas

        botonFrutas = findViewById(R.id.boton_fruta);

        botonFrutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Selection.this,Frutas.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });





        // 2 Guardamos la referencia del botón de verdurasas

        botonVerduras = findViewById(R.id.boton_verdura);

        botonVerduras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Selection.this,Verduras.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });





        // 3 Guardamos la referencia del botón de Legumbres

        botonLegumbres = findViewById(R.id.boton_legumbre);

        botonLegumbres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Selection.this,Legumbres.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });




        // 4 Guardamos la referencia del botón de Hortalizas

        botonHortalizas = findViewById(R.id.boton_hortaliza);

        botonHortalizas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Selection.this,Hortalizas.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });


        botonMenu = findViewById(R.id.btnMenu);

        botonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón regresar al menú principal.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (a la MainActivity)
                Intent intent = new Intent(Selection.this, MainActivity.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });



    }
}