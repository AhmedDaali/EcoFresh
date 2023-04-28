package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cliente extends AppCompatActivity {

    // Esta parte de código será declarada para el botón de continuar con el e-mail
    // Obtendremos el botón y lo dejaremos guardado en una variable que será un atributo de la clase
    // Es de tipo Button
    Button botonEmail;


    // Como el texto de login (Iniciar sesión) realiza la misma función que un botón, hacemos exactamente lo  mismo que el anterior

    TextView botonLogin;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();


        // 1
        // Aquí daremos la referencia del botón "botonEmail", mediante el identificador que está en la activity_cliente
        // se llama: "botonEmail". Por tanto buscamos con findViewById ese identificador en la clase R, con id "botonEmail"

        botonEmail = findViewById(R.id.botonEmail);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.

        botonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_registro.
            // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_registro (Registro.class)

                Intent intent = new Intent (Cliente.this,Registro.class);

            // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });



        // 2
        // Aquí daremos la referencia del botón "botonLogin", mediante el identificador que está en la activity_cliente
        // se llama: "TextoLogin". Por tanto buscamos con findViewById ese identificador en la clase R, con id "botonEmail"

        botonLogin = findViewById(R.id.textLogin);

        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_login.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_registro (registro.class)

                Intent intent = new Intent (Cliente.this,Login.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });



    }
}