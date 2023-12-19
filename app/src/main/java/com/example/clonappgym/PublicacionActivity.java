package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PublicacionActivity extends AppCompatActivity {
    int numeroImagen = 0;
    String nombreImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicacion);

        Button button = findViewById(R.id.Publicar_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout scrolleable = findViewById(R.id.publicaciones);
                LinearLayout publicacion = new LinearLayout(button.getContext());
                ImageView imagenPublicacion = new ImageView(button.getContext());
                TextView textoPublicacion = new TextView(button.getContext());
                publicacion.setOrientation(LinearLayout.VERTICAL);

                // Incrementa y luego asigna el nombre
                numeroImagen++;
                nombreImagen = "foto" + numeroImagen;

                int idImagen = getResources().getIdentifier(nombreImagen, "drawable", getPackageName());
                if (idImagen != 0) {
                    imagenPublicacion.setBackground(getDrawable(idImagen));
                } else {
                    Log.e("TAG", "No se encontro la imagen con el nombre: " + nombreImagen);
                }

                textoPublicacion.setText("Publicacion: " + nombreImagen);

                publicacion.addView(imagenPublicacion);
                publicacion.addView(textoPublicacion);

                scrolleable.addView(publicacion);
            }
        });
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
