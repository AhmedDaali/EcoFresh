package com.example.ecofresh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Muestrario extends AppCompatActivity {

    Button botonRegreso;

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    String emailUsuario;

    ListView listViewProductos;
    List<String> listaCantidad = new ArrayList<>();

    List<String> listaIdProductos = new ArrayList<>();
    ArrayAdapter<String> mAdapterProductos;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
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

                Intent intent = new Intent(Muestrario.this,Selection.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });



        // Aquí inicializo las instancias de Firebase

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        emailUsuario = mAuth.getCurrentUser().getEmail();
        listViewProductos = findViewById(R.id.listViewProductos);

        // Una vez que entra el usuario a esta activity debemos actualizar la interfaz de usuario con sus propias ventas, del usuario logueado

        actualizarUI();






    }

    @SuppressLint("WrongViewCast")
    private void actualizarUI() {

        db.collection("Productos")
                .whereEqualTo("email", emailUsuario)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {

                            return;
                        }

                        listaCantidad.clear();
                        // listaComprador.clear();
                        // listaProducto.clear();
                        listaIdProductos.clear();
                        for (QueryDocumentSnapshot doc : value) {

                            listaIdProductos.add(doc.getId());
                            listaCantidad.add(String.valueOf(doc.getDouble("cantidad")));
                            // listaComprador.add(doc.getString("comprador"));
                            //  listaProducto.add(doc.getString("producto"));


                        }

                        if (listaCantidad.size() == 0) {

                            listViewProductos.setAdapter(null);

                        } else {

                            mAdapterProductos = new ArrayAdapter<>(Muestrario.this, R.layout.item_ventas_realizadas, R.id.textViewCantidad, listaCantidad);

                            listViewProductos.setAdapter(mAdapterProductos);

                        }

                       /* if (listaComprador.size() == 0 ){

                            listViewVentas.setAdapter(null);

                        }else{

                            mAdapterVentas = new ArrayAdapter<>(VentasRealizadas.this,R.layout.item_ventas_realizadas,R.id.textViewComprador,listaComprador);

                            listViewVentas.setAdapter(mAdapterVentas);

                        }

                        if (listaProducto.size() == 0 ){

                            listViewVentas.setAdapter(null);

                        }else{

                            mAdapterVentas = new ArrayAdapter<>(VentasRealizadas.this,R.layout.item_ventas_realizadas,R.id.textViewProducto,listaProducto);

                            listViewVentas.setAdapter(mAdapterVentas);

                        }*/

                    }
                });







    }

}