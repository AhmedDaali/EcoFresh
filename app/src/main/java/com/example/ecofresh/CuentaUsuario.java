package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CuentaUsuario extends AppCompatActivity {


    Button botonEditar;

    Button botonMenu;

    RelativeLayout botonCompras;

    RelativeLayout botonVentas;

    private TextView textNombre;
    private TextView textApellidos;
    private TextView textEmail;
    private TextView textTelefono;
    private TextView textDireccion;
    private TextView textLocalidad;

    FirebaseFirestore db;
    private FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_usuario);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();

        // Inicializar Firebase Firestore
        db = FirebaseFirestore.getInstance();

        // Obtener usuario actual
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        // Referencias a los elementos de la interfaz
        textNombre = findViewById(R.id.textViewNombre);
        textApellidos = findViewById(R.id.textViewNombre2);
        textEmail = findViewById(R.id.textViewNombre3);
        textTelefono = findViewById(R.id.textViewNombre4);
        textDireccion = findViewById(R.id.textViewNombre5);
        textLocalidad = findViewById(R.id.textViewNombre6);

        // Obtener los datos del usuario desde Firestore
        obtenerDatosUsuario();

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
// ...

    private void obtenerDatosUsuario() {
        // Obtener referencia al documento del usuario en Firestore
        DocumentReference usuarioRef = db.collection("usuarios").document(currentUser.getUid());

        usuarioRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    // Obtener los datos del documento y actualizar los TextView correspondientes
                    String nombre = document.getString("nombre");
                    String apellidos = document.getString("apellidos");
                    String email = document.getString("email");
                    String telefono = document.getString("telefono");
                    String direccion = document.getString("direccion");
                    String localidad = document.getString("localidad");

                    textNombre.setText(nombre);
                    textApellidos.setText(apellidos);
                    textEmail.setText(email);
                    textTelefono.setText(telefono);
                    textDireccion.setText(direccion);
                    textLocalidad.setText(localidad);
                }
            } else {
                // Error al obtener los datos
            }
        });
    }

// ...

}