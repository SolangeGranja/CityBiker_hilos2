package com.example.estudiante.citybiker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class pantalla3 extends AppCompatActivity {
    private ImageView escenariocompleto;
    private  ImageView ciclista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //setContentView(R.layout.activity_pantalla3);
        setContentView(new juego(this));

    }
    public void obstaculos (View v) {
        Intent i = new Intent(this, obstaculos.class);
        startActivity(i);
    }
    public void puntajes (View v) {
        Intent i = new Intent(this, puntajes.class);
        startActivity(i);
    }
    public void atras (View v){
        Intent i = new Intent(this, proyectocitybiker.class);
        startActivity(i);

    }

}
