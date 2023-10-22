package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LinearLayout contentNews = findViewById(R.id.contenedorBotones);
        //TextView nuevaPublicacion = new TextView(this);
        //nuevaPublicacion.setText("Novedades de Spinning");
        //TextView otraPublicacion = new TextView(this);
        //otraPublicacion.setText("Horarios de Spinning");

        //contentNews.addView(nuevaPublicacion);
        //contentNews.addView(otraPublicacion);

        LinearLayout contentAfiche = findViewById(R.id.contenedorBotones);
        ImageView nuevoAfiche = new ImageView(this);
        int afiche = 0;
        afiche =(int) (Math.random()*4)+1;
        if (afiche ==1)
        {
            nuevoAfiche.setImageResource(R.drawable.afiche1);
            contentAfiche.addView(nuevoAfiche);
        }
        else if (afiche == 2)
        {
            nuevoAfiche.setImageResource(R.drawable.afiche3);
            contentAfiche.addView(nuevoAfiche);
        }
        else if (afiche == 3)
        {
            nuevoAfiche.setImageResource(R.drawable.afiche4);
            contentAfiche.addView(nuevoAfiche);
        }
        else
        {
            nuevoAfiche.setImageResource(R.drawable.afiche5);
            contentAfiche.addView(nuevoAfiche);
        }




    }
}