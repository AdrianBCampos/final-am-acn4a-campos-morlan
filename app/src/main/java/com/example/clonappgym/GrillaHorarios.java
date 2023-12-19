package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GrillaHorarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grilla_horarios);
    }
    public void paginainscripcion(View v){
        Intent intent = new Intent(getApplicationContext(), InscripcionActivity.class);
        startActivity(intent);
    }

    public void paginaPrincipal(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void obtenerIngresoQr(View v){
        Intent intent = new Intent (getApplicationContext(), QrViewActivity.class);
        startActivity(intent);
    }

    public void infoApi(View v) {

        Intent intent = new Intent(getApplicationContext(), ApiActivity.class);
        startActivity(intent);

    }
    public void contacto(View v) {

        Intent intent = new Intent(getApplicationContext(), ContactoActivity.class);

        startActivity(intent);

    }

}