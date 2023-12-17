package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ApiActivity extends AppCompatActivity {
    public void checkConnectionOnClick2(View v){

        checkConnection();

    }


    public void checkConnection(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        TextView msj = findViewById(R.id.textView);
        Button button4 = findViewById(R.id.button4);
        Button volver = findViewById(R.id.volver_mp);
        if (networkInfo != null && networkInfo.isConnected()){
            Log.i ("network.testing", "probando la red");

            msj.setText("Conectado a internet");
            msj.setVisibility((View.VISIBLE));
            volver.setVisibility(View.VISIBLE);
            button4.setVisibility(View.INVISIBLE);
            GetApiGym ejercicios = new GetApiGym();
            ejercicios.execute("https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/dist/exercises.json");

        } else {
            msj.setText("No hay conexion a internet");
            msj.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            volver.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        checkConnection();

    }

    public void paginaPrincipal(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);
    }




}