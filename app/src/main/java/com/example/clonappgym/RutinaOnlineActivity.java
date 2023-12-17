package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RutinaOnlineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_online);
    }

    public void paginaBajarPeso(View v){
        Intent intent = new Intent(getApplicationContext(), BajarDePesoActivity.class);
        startActivity(intent);
    }

    public void paginaGanarMasa(View v){
        Intent intent = new Intent(getApplicationContext(), GanarMasaMuscularActivity.class);
        startActivity(intent);
    }

    public void paginaDefinicion(View v){
        Intent intent = new Intent(getApplicationContext(), DefinicionActivity.class);
        startActivity(intent);
    }

    public void paginaResistencia(View v){
        Intent intent = new Intent(getApplicationContext(), ResistenciaAerobicaActivity.class);
        startActivity(intent);
    }

    public void paginaFlexibilidad(View v){
        Intent intent = new Intent(getApplicationContext(), GanarFlexibilidad.class);
        startActivity(intent);
    }
    public void paginaPrincipal(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}