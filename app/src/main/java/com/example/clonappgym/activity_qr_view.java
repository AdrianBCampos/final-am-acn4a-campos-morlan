package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_qr_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_view);
    }
    public void loadImage(View v){
        ImageView imageView = findViewById(R.id.imageQR);
        String urlqr ="https://raw.githubusercontent.com/AdrianBCampos/imagenes/main/Codigo-qr.png";
        Log.i("Testing",urlqr);
        Downloader descarga = new Downloader(imageView);
        descarga.execute(urlqr);
        TextView msj = findViewById(R.id.text_qr_activity);
        msj.setText(R.string.este_es_tu_c_digo_qr_para_ingresar_al_gym);
        msj.setBackgroundColor(+R.color.black);



    }

    public void paginaPrincipal(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);
    }


}