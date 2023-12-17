package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BajarDePesoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajar_de_peso);
    }

    public void paginaRutinas(View v){
        Intent intent = new Intent(getApplicationContext(), RutinaOnlineActivity.class);
        startActivity(intent);
    }
}