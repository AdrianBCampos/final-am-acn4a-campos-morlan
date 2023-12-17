package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InscripcionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscripcion);
    }

    public void enviarClase(View v){
        Toast.makeText(InscripcionActivity.this, "Inscripcion Realizada Correctamente", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), GrillaHorarios.class);
        startActivity(intent);
    }
    public void paginaGrilla(View v){
        Intent intent = new Intent(getApplicationContext(), GrillaHorarios.class);
        startActivity(intent);
    }
}