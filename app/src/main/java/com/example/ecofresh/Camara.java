package com.example.ecofresh;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camara extends AppCompatActivity {

    // Estas son las variables del botón y el visor de la cámara

    Button btnCamara;
    ImageView visor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);


        // Asignamos el botón a la variable vtnCamara

        btnCamara = findViewById(R.id.btnCamara);

        // Asignamos el botón a la variable

        visor = findViewById(R.id.iv_visor);

        // Aquí llamamos a la función cuando pulsamos el botón

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                camaraLauncher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));

            }
        });


    }

    ActivityResultLauncher<Intent> camaraLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            if(result.getResultCode() == RESULT_OK){

                Bundle extras = result.getData().getExtras();
                Bitmap imgBitmap = (Bitmap) extras.get("data");
                visor.setImageBitmap(imgBitmap);
            }

        }
    });



}