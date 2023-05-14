package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registro extends AppCompatActivity {


    // Esta parte de código será declarada para el botón de entrar en la activity_main
    // Obtendremos el botón y lo dejaremos guardado en una variable que será un atributo de la clase
    // Es de tipo Button
    Button botonEnter;

    // Boton de las condiciones
    TextView condiciones;

    // Boton de la política
    TextView politica;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();


        // 1
        // Aquí daremos la referencia del botón "botonEnter", mediante el identificador que está en la activity_registro
        // se llama: "Enter". Por tanto buscamos con findViewById ese identificador en la clase R, con id "Enter"

        botonEnter = findViewById(R.id.Enter);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.

        botonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_main.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_main (MainActivity.class)

                Intent intent = new Intent (Registro.this,MainActivity.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });


        // 2
        // Aquí daremos la referencia del texto "condiciones", mediante el identificador que está en la activity_registro
        // se llama: "checkBox2". Por tanto buscamos con findViewById ese identificador en la clase R, con id "checkBox2"

        condiciones = findViewById(R.id.checkBox2);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.

        condiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el texto pasamos a la activity_condiciones.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_condiciones (Condiciones.class)

                Intent intent = new Intent (Registro.this,Condiciones.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });


        // 3
        // Aquí daremos la referencia del texto "politica", mediante el identificador que está en la activity_registro
        // se llama: "checkBox4". Por tanto buscamos con findViewById ese identificador en la clase R, con id "checkBox4"

        politica = findViewById(R.id.checkBox4);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.

        politica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_condiciones.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_condiciones (Condiciones.class)

                Intent intent = new Intent (Registro.this,Condiciones.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });

    }
}