package com.example.ecofresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        // Esta es la parte de la entrada del titulo ECO

        TextView titulo_eco = (TextView) findViewById(R.id.titulo_eco);
        Animation animTitulo_eco = AnimationUtils.loadAnimation(this, R.anim.entrada_letra_eco);
        titulo_eco.startAnimation(animTitulo_eco);


        // Esta es la parte de la entrada del titulo FRESH

        TextView titulo_fresh = (TextView) findViewById(R.id.titulo_fresh);
        Animation animTitulo_fresh = AnimationUtils.loadAnimation(this, R.anim.entrada_letra_fresh);
        titulo_fresh.startAnimation(animTitulo_fresh);


        // Esta es la parte del salto de la manzana

        ImageView aple = (ImageView) findViewById(R.id.aple);
        Animation animAple = AnimationUtils.loadAnimation(this, R.anim.salto_manzana);
        aple.startAnimation(animAple);


        ImageView logo = (ImageView) findViewById(R.id.logo);
        Animation animLogo = AnimationUtils.loadAnimation(this, R.anim.desplegar_logo);
        logo.startAnimation(animLogo);




    }
}