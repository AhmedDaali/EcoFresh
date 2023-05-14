package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class Venta extends AppCompatActivity {




    // Variable que guardará la referencia del botón subir foto

    Button botonSubirFoto;

    // Variable que guardará la referencia del botón Confirmar

    Button botonConfirm;








    // Esto es el código para la entrada de texto autocompletable

    AutoCompleteTextView autoCategoria;

    String[] categorias = {

            "Frutas", "Verduras", "Hortalizas", "Legumbres"

    };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();


        // 1
        // Aquí daremos la referencia del botón "botonSubirFoto", mediante el identificador que está en la activity_venta
        // se llama: "subirFoto". Por tanto buscamos con findViewById ese identificador en la clase R, con id "subirFoto"

        botonSubirFoto = findViewById(R.id.subirFoto);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.¿?

        botonSubirFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_camara.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_camara (Camara.class)

                Intent intent = new Intent (Venta.this,Camara.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });





        // 2
        // Aquí daremos la referencia del botón "botonConfirm", mediante el identificador que está en la activity_venta
        // se llama: "Confirmar". Por tanto buscamos con findViewById ese identificador en la clase R, con id "Confirmar"

        botonConfirm = findViewById(R.id.Confirmar);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.¿?

        botonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_confirm_venta.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_confirm_venta (ConfirmVenta.class)

                Intent intent = new Intent (Venta.this,ConfirmVenta.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });





        // Esto se hace para que se autocomplete la entrada de texto de la categoría

        autoCategoria = (AutoCompleteTextView) findViewById(R.id.text_auto);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, categorias);
        autoCategoria.setThreshold(3); // Indicamos con cuántas letras empezará a autocompletar
        autoCategoria.setAdapter(adapter);



    }
}