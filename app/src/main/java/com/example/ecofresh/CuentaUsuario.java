package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class CuentaUsuario extends AppCompatActivity {


    Button botonEditar;

    Button botonMenu;

    RelativeLayout botonCompras;

    RelativeLayout botonVentas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_usuario);



        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();





        botonEditar = findViewById(R.id.btnEditar);

        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Intent intent = new Intent(CuentaUsuario.this, Edicion.class);

                 startActivity(intent);

            }
        });





        botonMenu = findViewById(R.id.btnMenuSel);

        botonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_confirm_venta.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_confirm_venta (ConfirmVenta.class)

                Intent intent = new Intent(CuentaUsuario.this, MainActivity.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });





        botonCompras = findViewById(R.id.marcador1);

        botonCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_confirm_venta.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_confirm_venta (ConfirmVenta.class)

                Intent intent = new Intent(CuentaUsuario.this, Compras.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });




        botonVentas = findViewById(R.id.marcador2);

        botonVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la siguiente activity_confirm_venta.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_confirm_venta (ConfirmVenta.class)

                Intent intent = new Intent(CuentaUsuario.this, Ventas.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });











    }
}