package com.example.ecofresh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImagenCompra extends AppCompatActivity {

    private Button botonComprar;

    private Button botonRegresar;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    private String  comprador, vendedor, nombreProducto, localidad,  precio, emailUsuario, imageUrl;

    private ImageView imageProducto;

    private List<String> listaImagenes ;

    private ArrayAdapter<String> mAdapterImagenes;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_compra);

        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();

        //Inicializamos la imágen
        imageProducto = findViewById(R.id.imageView3);

        // Aquí inicializo las instancias de Firebase

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        emailUsuario = mAuth.getCurrentUser().getEmail();

        // Obtener los datos de la compra del Intent.
        comprador = getIntent().getStringExtra("comprador");
        vendedor = getIntent().getStringExtra("vendedor");
        nombreProducto= getIntent().getStringExtra("producto");
        localidad = getIntent().getStringExtra("localidad");
        precio = getIntent().getStringExtra("precio");
        imageUrl = getIntent().getStringExtra("photoUrls");

        // 1 Guardamos la referencia del botón de confirmar
        botonComprar = findViewById(R.id.boton_confirmar_compra);

        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ImagenCompra.this,UltimoPasoCompra.class);

                intent.putExtra("producto", nombreProducto);
                intent.putExtra("localidad", localidad);
                intent.putExtra("precio", precio);
                intent.putExtra("vendedor", vendedor);
                intent.putExtra("photoUrls",imageUrl);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });

        // 2 Guardamos la referencia del botón de regreso

        botonRegresar = findViewById(R.id.boton_regreso_imagen);

        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ImagenCompra.this,Selection.class);

                // Arrancamos el evento que acabamos de crear
                startActivity(intent);

            }
        });


        // Una vez que entra el usuario a esta activity debemos actualizar la interfaz de usuario con sus propias ventas, del usuario logueado
        actualizarUI( nombreProducto);

    }

    private void actualizarUI(String nombreProducto) {
        mAdapterImagenes = new ArrayAdapter<String>(ImagenCompra.this, R.layout.activity_imagen_compra, R.id.imageView3, listaImagenes ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ImageView imageProducto = view.findViewById(R.id.imageView3);

                db.collection("VentasRealizadas")
                        .whereEqualTo("producto.nombre", nombreProducto)
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                if (error != null) {
                                    // Manejar el error aquí
                                    return;
                                }

                                for (QueryDocumentSnapshot doc : value) {
                                    // Obtener la URL de la imagen para el elemento actual en la posición 'position'
                                    //String imageUrl = doc.getString("producto.photoUrls");

                                    if (imageUrl != null && !imageUrl.isEmpty()) {
                                        Picasso.get().load(imageUrl).into(imageProducto);
                                    } else {
                                                mAdapterImagenes = new ArrayAdapter<>(ImagenCompra.this, R.layout.activity_imagen_compra, R.id.imageView3, listaImagenes);
                                                listaImagenes.add(String.valueOf(mAdapterImagenes));
                                    }
                                }
                            }
                        });

                return view;
            }
        };
    }
}

        /*db.collection("VentasRealizadas")
                .whereEqualTo("producto.nombre", nombreProducto)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            // Manejar el error aquí
                            return;
                        }


                        //listaVentas = new ArrayList<>();

                        //listaImagenes.clear(); // Limpiar la lista de imágenes antes de agregar las nuevas




                        for (QueryDocumentSnapshot doc : value) {
                            listaImagenes.add(doc.getId());


                            } else {


                                cantidad = doc.getDouble("cantidad");
                                vendedor = doc.getString("vendedor");

                                // Obtiene los datos del producto directamente del documento actual
                                precio = doc.getDouble("producto.precio");
                                nombre = doc.getString("producto.nombre");
                                localidad = doc.getString("producto.localidad");

                                // Combina los datos en una sola cadena
                                String venta = "  Producto:     " + nombre + "\n" +
                                        "  Vendedor:    " + vendedor + "\n" +
                                        "  Localidad:    " + localidad + "\n" +
                                        "  Stock:           " + cantidad + "\n" +
                                        "  Precio:          " + precio;

                                // Agrega la cadena a la lista
                                listaVentas.add(venta);
                            }
                        }

                        if (listaVentas.size() == 0) {
                            listViewProductos.setAdapter(null);
                        } else {
                            mAdapterProductos = new ArrayAdapter<>(Muestrario.this, R.layout.item_muestrario, R.id.textViewProducto, listaVentas);
                            listViewProductos.setAdapter(mAdapterProductos);
                        }
                        for (QueryDocumentSnapshot doc : value) {


                            String imageUrl = doc.getString("producto.photoUrls");
                            if (imageUrl != null && !imageUrl.isEmpty()) {
                                listaImagenes.add(imageUrl);
                                //Picasso.get().load(imageUrl).into(imageProducto);
                            } else {
                                mAdapterImagenes = new ArrayAdapter<>(Muestrario.this, R.layout.item_muestrario, R.id.imageProducto, listaImagenes);
                                listViewProductos.setAdapter(mAdapterImagenes);
                            }
                        }

                        //mAdapterProductos.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
                    }

                });*/

