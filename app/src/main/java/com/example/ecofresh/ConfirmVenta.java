package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ConfirmVenta extends AppCompatActivity {


    // Variable que guardará la referencia del botón Menú principal
    Button botonMenu;

    // Variable que guardará la referencia del botón salir
    Button botonSalir;

    //Variables de textView
    private TextView nombre;
    private TextView cantidad;
    private TextView nombreProducto;
    private TextView precio;
    private TextView localidad;

    //Imágen de la activity
    //private ImageView image;
    //private Bitmap foto;

    //Almacen de archivos
    //private StorageReference storageRef;

    private FirebaseFirestore db;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_venta);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();

        // Obtén una instancia de FirebaseStorage y una referencia al almacenamiento
        //FirebaseStorage storage = FirebaseStorage.getInstance();
        //storageRef = storage.getReference();

        // Inicializar Firebase Firestore
        db = FirebaseFirestore.getInstance();

        // Obtener usuario actual
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        // Referencias a los elementos de la interfaz
        nombre = findViewById(R.id.textVendedor);
        cantidad = findViewById(R.id.textCantidad);
        nombreProducto = findViewById(R.id.textProducto);
        precio = findViewById(R.id.textPrecio);
        localidad = findViewById(R.id.textLocalidad);

        // Obtener los datos del usuario desde Firestore
        obtenerDatosUsuario();

        // Obtener los datos de la venta desde Firestore
        obtenerDatosVenta();

        // Obtener los datos del producto desde Firestore
        obtenerDatosProducto();



        // 1
        // Aquí daremos la referencia del botón "botonMenu", mediante el identificador que está en la activity_confirm_venta
        // se llama: "btnMenu". Por tanto buscamos con findViewById ese identificador en la clase R, con id "btnMenu"

        botonMenu = findViewById(R.id.btnMenu);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.¿?

        botonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la activity_main.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_main(MainActivity.class)

                Intent intent = new Intent (ConfirmVenta.this,MainActivity.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });


        // 2
        // Aquí daremos la referencia del botón "botonSalir", mediante el identificador que está en la activity_confirm_venta
        // se llama: "salir". Por tanto buscamos con findViewById ese identificador en la clase R, con id "salir"

        botonSalir = findViewById(R.id.salir);


        // Ahora debemos ponerlo a la escucha, para saber cuándo se clica sobre él, con el método setOnClickListener()
        // Dentro del paréntesis que está vacío, debemos crear un nuevo objeto: new View.OnClickListener()
        // Con la interface View.OnClickListener, sobreescribimos el método public void onClick.
        // Al tener muchos botones, es mejor sacarlo del método onCreate.¿?

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // De momento queremos que al hacer click en el botón pasemos a la activity_inicial.
                // Para ello debemos crear un objeto de la clase Intent. Introduciendo en el paréntesis, que pase de esta activity (this) a la activity_inicial (Inicial.class)

                Intent intent = new Intent (ConfirmVenta.this,Inicial.class);

                // Arrancamos el evento que acabamos de crear

                startActivity(intent);

            }
        });
    }

    private void obtenerDatosUsuario() {
        // Obtener referencia al documento del usuario en Firestore
        DocumentReference usuarioRef = db.collection("usuarios").document(currentUser.getEmail());

        usuarioRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    // Obtener los datos del documento y actualizar los TextView correspondientes
                    String nombreUser = document.getString("nombre");
                    String localidadVenta = document.getString("localidad");
                    //String cantidadVent = document.getString("cantidad");
                    //cantidad.setText("Cantidad:   " + cantidadVent);

                    nombre.setText("Nombre:     " + nombreUser);
                    localidad.setText("Localidad:  " + localidadVenta);

                    // Obtener referencia a la subcolección "venta"
                    CollectionReference ventaCollectionRef = usuarioRef.collection("venta");

                    ventaCollectionRef.document("cantidad").get().addOnCompleteListener(cantidadTask -> {
                        if (cantidadTask.isSuccessful()) {
                            DocumentSnapshot cantidadDocument = cantidadTask.getResult();
                            if (cantidadDocument.exists()) {
                                String cantidadVenta = cantidadDocument.getString("cantidad");
                                cantidad.setText("Cantidad:   " + cantidadVenta);
                            } else {
                                // El documento "cantidad" no existe
                            }
                        } else {
                            // Manejar el error al obtener el documento "cantidad"
                        }
                    });
                }
            } else {
                Toast.makeText(ConfirmVenta.this, "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void obtenerDatosVenta(){
        // Obtener referencia al documento del usuario en Firestore
        // Obtener referencia a la subcolección "venta"
        DocumentReference ventaRef = db.collection("usuarios").document(currentUser.getEmail()).collection("venta").document("cantidad");


        ventaRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    String cantidadVenta = document.getString("cantidad");
                    cantidad.setText("Cantidad:   " + cantidadVenta);
                } else {
                    // El documento "cantidad" no existe
                }
            } else {
                // Manejar el error al obtener el documento "cantidad"
            }
        });
    }

    private void obtenerDatosProducto(){
        // Obtener referencia al documento de producto en Firestore
        DocumentReference usuarioRef = db.collection("usuarios").document(currentUser.getEmail()).collection("venta").document("producto");

        // Obtener referencia a la subcolección "venta"
        CollectionReference ventaCollectionRef = usuarioRef.collection("venta");

        // Obtener referencia a la subcolección "venta"
        CollectionReference productoRef = usuarioRef.collection("producto");
        productoRef.document("producto").get().addOnCompleteListener(productoTask -> {
            if (productoTask.isSuccessful()) {
                DocumentSnapshot ProductoDocument = productoTask.getResult();
                if (ProductoDocument.exists()) {
                    String nombreP = ProductoDocument.getString("nombre");
                    String precioVent = ProductoDocument.getString("precio");
                    nombreProducto.setText("Producto:   " + nombreP);
                    precio.setText("Producto:   " + precioVent);
                } else {
                    // El documento "cantidad" no existe
                }
            } else {
                // Manejar el error al obtener el documento "cantidad"
            }
        });

    }

}