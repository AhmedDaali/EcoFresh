package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmVenta extends AppCompatActivity {


    // Variable que guardará la referencia del botón Menú principal

    Button botonMenu;

    // Variable que guardará la referencia del botón salir

    Button botonSalir;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_venta);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();





        // 1
        // Aquí daremos la referencia del botón "botonMenu", mediante el identificador que está en la activity_confirm_venta
        // se llama: "btnMenu". Por tanto buscamos con findViewById ese identificador en la clase R, con id "btnMenu"

        botonMenu = findViewById(R.id.btnMenu);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.¿?

        botonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la activity_main.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_main(MainActivity.class)

                Intent intent = new Intent (ConfirmVenta.this,MainActivity.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });





        // 2
        // Aquí daremos la referencia del botón "botonSalir", mediante el identificador que está en la activity_confirm_venta
        // se llama: "salir". Por tanto buscamos con findViewById ese identificador en la clase R, con id "salir"

        botonSalir = findViewById(R.id.salir);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.¿?

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la activity_inicial.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_inicial (Inicial.class)

                Intent intent = new Intent (ConfirmVenta.this,Inicial.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });




    }
}