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

        // Obtener los datos de la venta de la venta del Intent.
        String nombreProducto = getIntent().getStringExtra("producto");

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

        actualizarUI( nombreProducto);






    }


    private void actualizarUI(String nombreProducto) {

        db.collection("VentasRealizadas")
                .whereEqualTo("producto.nombre", nombreProducto)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            // Manejar el error aquí
                            return;
                        }

                        List<String> listaVentas = new ArrayList<>();
                        for (QueryDocumentSnapshot doc : value) {
                            listaIdProductos.add(doc.getId());

                            String cantidad = doc.getString("cantidad");
                            String vendedor = doc.getString("vendedor");

                            // Obtiene los datos del producto directamente del documento actual
                            String precio = doc.getString("producto.precio");
                            String nombre = doc.getString("producto.nombre");
                            String localidad = doc.getString("producto.localidad");

                            // Combina los datos en una sola cadena
                            String venta = "  Producto:     " + nombre + "\n" +
                                    "  Vendedor:    " + vendedor + "\n" +
                                    "  Localidad:    " + localidad + "\n" +
                                    "  Stock:           " + cantidad + "\n" +
                                    "  Precio:          " + precio;

                            // Agrega la cadena a la lista
                            listaVentas.add(venta);
                        }

                        if (listaVentas.size() == 0) {
                            listViewProductos.setAdapter(null);
                        } else {
                            mAdapterProductos = new ArrayAdapter<>(Muestrario.this, R.layout.item_muestrario, R.id.textViewProducto, listaVentas);
                            listViewProductos.setAdapter(mAdapterProductos);
                        }
                    }
                });

    }

}