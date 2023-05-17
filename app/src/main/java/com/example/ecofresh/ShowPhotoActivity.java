package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShowPhotoActivity extends AppCompatActivity {
    private ImageView imageView;
    private Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        imageView = findViewById(R.id.imageView);
        photo = getIntent().getParcelableExtra("photo");
        imageView.setImageBitmap(photo);

        Button btnSave = findViewById(R.id.btnSave);
        // Con esta linea ocultamos el actionBar, la barra de acción situada arriba de todo

        getSupportActionBar().hide();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePhoto();
            }
        });

        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePhoto();
            }
        });
    }

    private void savePhoto() {
        // Aquí puedes agregar el código para guardar la foto en Firebase
        // Puedes usar Firebase Storage o Firestore para almacenar la imagen

        // Una vez que hayas guardado la foto, puedes volver a la actividad principal
        Intent intent = new Intent(ShowPhotoActivity.this, Venta.class);
        startActivity(intent);
    }

    private void deletePhoto() {
        // Aquí puedes agregar el código para borrar la foto de Firebase

        // Una vez que hayas borrado la foto, puedes volver a la actividad principal
        Intent intent = new Intent(ShowPhotoActivity.this, Venta.class);
        startActivity(intent);
    }
}
