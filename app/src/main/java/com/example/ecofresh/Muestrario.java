package com.example.ecofresh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Muestrario extends AppCompatActivity {

    Button botonRegreso;

    List<String> listaVentas;

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    String emailUsuario;

    ListView listViewProductos;
    List<String> listaImagenes = new ArrayList<>();

    List<String> listaIdProductos = new ArrayList<>();
    ArrayAdapter<String> mAdapterProductos;

    private ImageView imageProducto;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestrario);

        // Obtener los datos de la venta de la venta del Intent.
        String nombreProducto = getIntent().getStringExtra("producto");

        //Inicializamos la imágen
        imageProducto = findViewById(R.id.imageProducto);

        listViewProductos = findViewById(R.id.listViewProductos);
        listViewProductos.setAdapter(mAdapterProductos);

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


<<<<<<< HEAD
=======

>>>>>>> a11adf6d5affd469d5d100b2bb4d411d102d9493
        // Aquí inicializo las instancias de Firebase

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        emailUsuario = mAuth.getCurrentUser().getEmail();
        listViewProductos = findViewById(R.id.listViewProductos);


        // Una vez que entra el usuario a esta activity debemos actualizar la interfaz de usuario con sus propias ventas, del usuario logueado

        actualizarUI( nombreProducto);


    }


    private void actualizarUI(String nombreProducto) {
        mAdapterProductos = new ArrayAdapter<String>(Muestrario.this, R.layout.item_muestrario, R.id.imageProducto, listaImagenes ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ImageView imageProducto = view.findViewById(R.id.imageProducto);

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
                                    String imageUrl = doc.getString("producto.photoUrls");

                                    if (imageUrl != null && !imageUrl.isEmpty()) {
                                        Picasso.get().load(imageUrl).into(imageProducto);
                                    } else {
                                        // Si no hay una URL de imagen válida, puedes mostrar una imagen de relleno o dejarla vacía.
                                        // Por ejemplo:
                                        // imageProducto.setImageResource(R.drawable.placeholder_image);
                                        // O simplemente:
                                        // imageProducto.setImageDrawable(null);
                                    }
                                }
                            }
                        });

                return view;
            }
        };

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


                       listaVentas = new ArrayList<>();

                        listaImagenes.clear(); // Limpiar la lista de imágenes antes de agregar las nuevas


<<<<<<< HEAD
=======
                     
>>>>>>> a11adf6d5affd469d5d100b2bb4d411d102d9493

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
                        for (QueryDocumentSnapshot doc : value) {


                            String imageUrl = doc.getString("producto.photoUrls");
                            if (imageUrl != null && !imageUrl.isEmpty()) {
                                listaImagenes.add(imageUrl);
                               // Picasso.get().load(imageUrl).into(imageProducto);
                            } else {
                                // Si no hay una URL de imagen válida, puedes mostrar una imagen de relleno o dejarla vacía.
                                // Por ejemplo:
                                //listaImagenes.add(""); // Agrega una cadena vacía
                            }
                        }

                        //mAdapterProductos.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
                    }

                });

    }

<<<<<<< HEAD
    public void mostrarProducto (View view) {
=======
    public void mostrarProducto (View view){

    // Así obtenemos acceso al padre del textView, en este caso es el listView

    View parent = (View) view.getParent();

    // Obtenemos el textView. Guardamos en esta variable el TextView a través del padre

    //TextView ProductoTextView = parent.findViewById(R.id.textViewMuestraProducto);

    // Ahora necesitamos el contenido del anterior TextView, que guardaremoms en la variable siguiente

        //String producto = ProductoTextView.getText().toString();

    //
>>>>>>> a11adf6d5affd469d5d100b2bb4d411d102d9493

        View parent = (View) view.getParent();
        TextView ProductosTextView = parent.findViewById(R.id.textViewProducto);
        Intent intent = new Intent(Muestrario.this, UltimoPasoCompra.class);
        // Arrancamos el evento que acabamos de crear
        startActivity(intent);



    }







}