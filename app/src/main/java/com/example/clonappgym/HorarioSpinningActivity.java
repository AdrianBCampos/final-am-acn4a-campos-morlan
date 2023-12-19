package com.example.clonappgym;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HorarioSpinningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_spinning);

        Intent intent = this.getIntent();
        if(intent.hasExtra("newInfo")){

            // Obtener el mensaje del Intent
            String newInfoMessage = intent.getStringExtra("newInfo");

            // Obtener referencia al TextView en tu diseño
            TextView newInfoTextView = findViewById(R.id.newInfoCross);

            // Establecer el mensaje en el TextView
            newInfoTextView.setText(newInfoMessage);

            // Para verificar en el Logcat
            Log.i("TAG", "onCreate: recibimos extra con mensaje: " + newInfoMessage);


        }



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