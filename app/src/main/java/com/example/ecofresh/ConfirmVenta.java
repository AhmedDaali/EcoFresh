package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

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

    private ImageView imageView;

    //Imágen guardada
    private Bitmap photo;

    private FirebaseFirestore db;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_venta);


        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo
        getSupportActionBar().hide();

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
        imageView = findViewById(R.id.imageView2);

        // Obtener los datos del usuario desde Firestore
        obtenerDatosUsuario();

        // Obtener los datos de la venta de la venta del Intent.
        String cantidadVenta = getIntent().getStringExtra("cantidad");
        String productoVenta = getIntent().getStringExtra("producto");
        String  precioVenta= getIntent().getStringExtra("precio");
        String localidadVenta = getIntent().getStringExtra("localidad");
        photo = getIntent().getParcelableExtra("photo");

        //Colocar los datos de la venta en los textView
        cantidad.setText("Cantidad:    " + cantidadVenta+"Kg");
        nombreProducto.setText("Producto:   " + productoVenta);
        precio.setText("Precio/Kg:  " + precioVenta + "€/kg");
        localidad.setText("Localidad:  " + localidadVenta);
        imageView.setImageBitmap(photo);


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

                //Ponemos la foto a null para la próxima venta
                photo = null;

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

                //Ponemos la foto a null para la próxima venta
                photo = null;

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
                    nombre.setText("Vendedor:  " + nombreUser);
                }
            } else {
                Toast.makeText(ConfirmVenta.this, "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
/*package com.example.ecofresh;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.PersistableBundle;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.ecofresh.modelo.entidad.Usuario;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.SignInMethodQueryResult;
        import com.google.firebase.firestore.FirebaseFirestore;

        import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    Button botonEnter;
    TextView condiciones;
    TextView politica;
    CheckBox checkBoxCondiciones;
    EditText nombre, apellidos, email, password;
    FirebaseAuth mAuth;
    Boolean checkBoxState = false;
    private FirebaseFirestore db;
    private static final String EDIT_TEXT_VALUE_KEY = "edit_text_value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        nombre = findViewById(R.id.cajaNombre);
        apellidos = findViewById(R.id.cajaApellidos);
        email = findViewById(R.id.cajaEmail);
        password = findViewById(R.id.cajaContraseña);
        checkBoxCondiciones = findViewById(R.id.checkBox);
        checkBoxCondiciones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxState = isChecked;
            }
        });

        botonEnter = findViewById(R.id.Enter);
        botonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = email.getText().toString().trim();
                String passUser = password.getText().toString().trim();
                String name = nombre.getText().toString();
                String secondName = apellidos.getText().toString();

                if (name.isEmpty()) {
                    nombre.setError("Campo vacío.");
                } else if (name.length() < 2) {
                    nombre.setError("El nombre debe tener al menos 2 caracteres.");
                } else if (secondName.length() < 2) {
                    apellidos.setError("El apellido debe tener al menos 2 caracteres.");
                } else if (secondName.isEmpty()) {
                    apellidos.setError("Campo vacío.");
                } else if (emailUser.isEmpty()) {
                    email.setError("Campo vacío.");
                } else if (!validarEmail(emailUser)) {
                    email.setError("Por favor ingrese una dirección de correo electrónico válida.");
                } else if (passUser.length() < 6) {
                    password.setError("La contraseña debe tener al menos 6 caracteres.");
                } else if (!checkBoxState) {
                    Toast.makeText(Registro.this, "¡Por favor, acepta los términos y condiciones de uso!", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.fetchSignInMethodsForEmail(emailUser).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                        @Override
                        public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                            if (task.isSuccessful()) {
                                SignInMethodQueryResult result = task.getResult();
                                boolean isEmailRegistered = result.getSignInMethods().size() > 0;
                                if (isEmailRegistered) {
                                    Toast.makeText(Registro.this, "El correo electrónico ya está registrado", Toast.LENGTH_SHORT).show();
                                } else {
                                    mAuth.createUserWithEmailAndPassword(emailUser, passUser)
                                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(Registro.this, "¡Bienvenido " + name + "!", Toast.LENGTH_LONG).show();
                                                        Intent intent = new Intent(Registro.this, MainActivity.class);
                                                        startActivity(intent);
                                                    } else {
                                                        Toast.makeText(Registro.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                    db.collection("usuarios").document("dummy").get().addOnFailureListener(e -> {
                                        if (e.getMessage() != null && e.getMessage().contains("No document exists")) {
                                            db.collection("usuarios").document("dummy").set(new Usuario()).addOnSuccessListener(aVoid -> {
                                                Toast.makeText(Registro.this, "Se creó la colección 'usuarios'", Toast.LENGTH_SHORT).show();
                                            }).addOnFailureListener(error -> {
                                                Toast.makeText(Registro.this, "Error al crear la colección 'usuarios'", Toast.LENGTH_SHORT).show();
                                            });
                                        } else {
                                            Toast.makeText(Registro.this, "Error al acceder a la colección 'usuarios'", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                    Usuario usuarioCreado = new Usuario(name, secondName, emailUser);
                                    db.collection("usuarios").document(emailUser).set(usuarioCreado)
                                            .addOnSuccessListener(aVoid -> {
                                                Toast.makeText(Registro.this, "Datos creados correctamente", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(Registro.this, MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            })
                                            .addOnFailureListener(e -> {
                                                Toast.makeText(Registro.this, "Error al crear los datos del usuario", Toast.LENGTH_SHORT).show();
                                            });
                                }
                            }
                        }
                    });
                }
            }
        });

        condiciones = findViewById(R.id.checkBox2);
        condiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registro.this, Condiciones.class);
                startActivity(intent);
            }
        });

        politica = findViewById(R.id.checkBox4);
        politica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registro.this, Condiciones.class);
                startActivity(intent);
            }
        });
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EDIT_TEXT_VALUE_KEY, email.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String editTextValue = savedInstanceState.getString(EDIT_TEXT_VALUE_KEY);
        email.setText(editTextValue);
    }
}*/
