package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity {

    public void enviar(View v){
        Toast.makeText(ContactoActivity.this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void paginaPrincipal(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        ImageView facebookImageView = findViewById(R.id.face);


        facebookImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFacebook();
            }
        });

        ImageView whatsappImageView = findViewById(R.id.whatsapp);

        whatsappImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirWhatsApp();
            }
        });

        ImageView instagramImageView = findViewById(R.id.insta);

        instagramImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirInstagram();
            }
        });


    }
    private void abrirFacebook() {
        String urlFacebook = "https:www.facebook.com/profile.php?id=61554917603955";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlFacebook));
        startActivity(intent);
    }

    private void abrirWhatsApp() {
        String numeroTelefono = "+5491135794494";

        try {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + numeroTelefono));
            startActivity(intent);
        } catch (Exception e) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"));
            startActivity(intent);
        }
    }

    private void abrirInstagram() {
        String perfilInstagram = "fitness_gym_tp";

        try {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://instagram.com/_u/" + perfilInstagram));
            startActivity(intent);
        } catch (Exception e) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.instagram.android"));
            startActivity(intent);
        }
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