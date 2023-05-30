package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class UltimoPasoCompra extends AppCompatActivity {

    // Variable que guardará la referencia del botón Confirmar
    private Button botonConfirm;

    private EditText cantidadEditText, calleEditText,
            localidadEditext, cpEditext;

    private String producto, vendedor, apellidos, precio, localidad;

    private FirebaseUser currentUser;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimo_paso_compra);

        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();

        // Obtén la instancia de FirebaseFirestore
        db = FirebaseFirestore.getInstance();

        // Obtener usuario actual
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        // Obtener Los datos del intent
        //String photoUrl = getIntent().getStringExtra("photoUrl");


        // Referencias a los elementos de la interfaz
        cantidadEditText = findViewById(R.id.EditTextCantidad);
        calleEditText = findViewById(R.id.textDireccion);
        localidadEditext = findViewById(R.id.textLugar);
        cpEditext = findViewById(R.id.textCp);

    }
}