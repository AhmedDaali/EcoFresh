package com.example.ecofresh;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VentasRealizadas extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    String emailUsuario;

    ListView listViewVentas;
    List<String> listaCantidad = new ArrayList<>();
    List<String> listaComprador = new ArrayList<>();
    List<String> listaProducto = new ArrayList<>();
    List<String> listaPrecio = new ArrayList<>();
    List<String> listaIdVentas = new ArrayList<>();
    ArrayAdapter<String> mAdapterVentas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas_realizadas);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();

        // Aquí inicializo las instancias de Firebase

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        emailUsuario = mAuth.getCurrentUser().getEmail();
        listViewVentas = findViewById(R.id.listViewVentasRealizadas);

        // Una vez que entra el usuario a esta activity debemos actualizar la interfaz de usuario con sus propias ventas, del usuario logueado

        actualizarUI();


    }

    private void actualizarUI() {

        db.collection("VentasRealizadas")
                .whereEqualTo("email", emailUsuario)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {

                            return;
                        }

                        listaCantidad.clear();
                        listaComprador.clear();
                        listaProducto.clear();
                        listaIdVentas.clear();
                        for (QueryDocumentSnapshot doc : value) {

                               listaIdVentas.add(doc.getId());
                               listaCantidad.add(doc.getString("cantidad"));
                               //listaComprador.add(doc.getString("comprador"));
                               //listaProducto.add(doc.get("producto").getClass().getName());
                               //listaPrecio.add(doc.get("producto").getClass().getName());

                        }

                        if (listaCantidad.size() == 0 ){

                            listViewVentas.setAdapter(null);

                        }else{

                            mAdapterVentas = new ArrayAdapter<>(VentasRealizadas.this,R.layout.item_ventas_realizadas,R.id.textViewCantidad,listaCantidad);

                            listViewVentas.setAdapter(mAdapterVentas);

                        }
                        /*if (listaPrecio.size() == 0 ){

                            listViewVentas.setAdapter(null);

                        }else{

                            mAdapterVentas = new ArrayAdapter<>(VentasRealizadas.this,R.layout.item_ventas_realizadas,R.id.textViewComprador,listaComprador);

                            listViewVentas.setAdapter(mAdapterVentas);

                        }*/

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