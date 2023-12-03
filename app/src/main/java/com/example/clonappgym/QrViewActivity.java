package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QrViewActivity extends AppCompatActivity {

    public void checkConnectionOnClick2(View v) {

        checkConnection();

    }


    public void checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        Button volver = findViewById(R.id.obtenerQR_btn2);
        ImageView fotoQr = findViewById(R.id.imageQR);

        TextView msj = findViewById(R.id.text_qr_activity);
        Button obtenerQr = findViewById(R.id.obtenerQR_btn);
        Button button5 = findViewById(R.id.button5);

        if (networkInfo != null && networkInfo.isConnected()) {
            Log.i("network.testing", "probando la red");

            button5.setVisibility(View.INVISIBLE);

            fotoQr.setVisibility(View.VISIBLE);
            msj.setText("(Hacé click en el botón para obtener tu codigo QR)");
            msj.setVisibility((View.VISIBLE));
            obtenerQr.setVisibility(View.VISIBLE);
            volver.setVisibility(View.VISIBLE);


        } else {
            msj.setText("No hay conexion a internet");
            msj.setVisibility(View.VISIBLE);
            button5.setVisibility(View.VISIBLE);
            volver.setVisibility(View.VISIBLE);
            obtenerQr.setVisibility(View.INVISIBLE);
            fotoQr.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_view);

        checkConnection();
    }

    public void loadImage(View v) {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        Button volver = findViewById(R.id.obtenerQR_btn2);
        ImageView fotoQr = findViewById(R.id.imageQR);

        TextView msj = findViewById(R.id.text_qr_activity);
        Button obtenerQr = findViewById(R.id.obtenerQR_btn);
        Button button5 = findViewById(R.id.button5);

        if (networkInfo != null && networkInfo.isConnected()) {
            Log.i("network.testing", "probando la red");

            button5.setVisibility(View.INVISIBLE);

            fotoQr.setVisibility(View.VISIBLE);
            msj.setText("(Hacé click en el botón para obtener tu codigo QR)");
            msj.setVisibility((View.VISIBLE));
            obtenerQr.setVisibility(View.VISIBLE);
            volver.setVisibility(View.VISIBLE);
            ImageView imageView = findViewById(R.id.imageQR);
            String urlqr = "https://raw.githubusercontent.com/AdrianBCampos/imagenes/main/Codigo-qr.png";
            Log.i("Testing", urlqr);
            Downloader descarga = new Downloader(imageView);
            descarga.execute(urlqr);

            msj.setText(R.string.este_es_tu_c_digo_qr_para_ingresar_al_gym);
            msj.setBackgroundColor(+R.color.black);


        } else {
            msj.setText("No hay conexion a internet");
            msj.setVisibility(View.VISIBLE);
            button5.setVisibility(View.VISIBLE);
            volver.setVisibility(View.VISIBLE);
            obtenerQr.setVisibility(View.INVISIBLE);
            fotoQr.setVisibility(View.INVISIBLE);
        }









    }

    public void paginaPrincipal(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);
    }

}
