package com.example.ecofresh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ProductosVenta extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String emailUsuario;

    private ListView listViewVentas;
    private List<String> listaIdVentas = new ArrayList<>();
    private ArrayAdapter<String> mAdapterVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_venta);

        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();

        // Aquí inicializo las instancias de Firebase

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        emailUsuario = mAuth.getCurrentUser().getEmail();
        listViewVentas = findViewById(R.id.listViewProductosVentas);

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
                            // Manejar el error aquí
                            return;
                        }

                        List<String> listaVentas = new ArrayList<>();
                        for (QueryDocumentSnapshot doc : value) {
                            listaIdVentas.add(doc.getId());

                            String cantidad = doc.getString("cantidad");

                            // Obtiene los datos del producto directamente del documento actual
                            String precio = doc.getString("producto.precio");
                            String nombre = doc.getString("producto.nombre");

                            // Combina los datos en una sola cadena
                            String venta = "  Producto:     " + nombre + "\n" +
                                    "  Cantidad:     " + cantidad + "\n" +
                                    "  Precio:          " + precio;

                            // Agrega la cadena a la lista
                            listaVentas.add(venta);
                        }

                        if (listaVentas.size() == 0) {
                            listViewVentas.setAdapter(null);
                        } else {
                            mAdapterVentas = new ArrayAdapter<>(ProductosVenta.this, R.layout.item_productos_venta, R.id.textViewVenta, listaVentas);
                            listViewVentas.setAdapter(mAdapterVentas);
                        }
                    }
                });
    }
}