package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ApiActivity extends AppCompatActivity {
    public void checkConnectionOnClick (View v){
        checkConnection();
    }


    public void checkConnection(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        TextView mensaje2 = findViewById(R.id.msj_no_internet2);
        Button button2 = findViewById(R.id.button33);
        if (networkInfo != null && networkInfo.isConnected()){
            Log.i ("network.testing", "probando la red");

            mensaje2.setVisibility (View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            GetApiGym ejercicios = new GetApiGym();
            ejercicios.execute("https://rickandmortyapi.com/api/character/?name=rick&status=alive");

        } else {
            mensaje2.setText("Internet no disponible");
            mensaje2.setVisibility(View.VISIBLE);
            button2.setVisibility (View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        checkConnection();

    }





}