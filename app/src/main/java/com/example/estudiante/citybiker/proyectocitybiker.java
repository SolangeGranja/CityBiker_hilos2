package com.example.estudiante.citybiker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class proyectocitybiker extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_proyecto_city_biker);

    }
public void cargar (View v) {
    Intent i = new Intent(this, jugabilidad.class);
    startActivity(i);
}
     public void jugar (View v){
        Intent i = new Intent(this, pantalla3.class);
         startActivity(i);


    }


}
