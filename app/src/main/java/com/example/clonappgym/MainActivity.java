package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

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

        ImageButton homeButton = findViewById(R.id.btn_home);
        homeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                TextView home = findViewById(R.id.home);
                home.setText(R.string.click_home);
                home.setBackgroundColor(+R.color.black);
            }
        });

        ImageButton calendarButton = findViewById(R.id.btn_agendar);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView agenda = findViewById(R.id.home);
                agenda.setText(R.string.click_agenda_text);
                agenda.setBackgroundColor(+R.color.black);


            }
        });

        ImageButton qrButton = findViewById(R.id.btn_qr);
        qrButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView qr = findViewById(R.id.home);
                qr.setText(R.string.click_qr_text);
                qr.setBackgroundColor(+R.color.black);



            }
        });

        ImageButton msgButton = findViewById(R.id.btn_correo);
        msgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView correo = findViewById(R.id.home);
                correo.setText(R.string.click_contact_text);
                correo.setBackgroundColor(+R.color.black);

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            String email= currentUser.getEmail();
            Log.i("firebase email", email);
        } else {
            Log.i("firebase email", "No hay usuario");
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            //this.login("dami@gmail.com", "123456");
        }
    }

    public void logout (View v){
        mAuth.signOut();

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}