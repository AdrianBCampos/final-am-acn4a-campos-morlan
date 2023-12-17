package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GanarFlexibilidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganar_flexibilidad);
    }

    public void paginaRutinas(View v){
        Intent intent = new Intent(getApplicationContext(), RutinaOnlineActivity.class);
        startActivity(intent);
    }
}