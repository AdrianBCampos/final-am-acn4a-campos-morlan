package com.example.clonappgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private String uid;

    public void checkConnectionOnClick (View v){
        checkConnection();
    }


    public void checkConnection(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        LinearLayout linearL = findViewById(R.id.BannerConteiner);
        TextView mensaje = findViewById(R.id.msj_no_internet);
        Button button = findViewById(R.id.button2);
        if (networkInfo != null && networkInfo.isConnected()){
            Log.i ("network.testing", "probando la red");
            linearL.setVisibility (View.VISIBLE);
            mensaje.setVisibility (View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
        } else {
            linearL.setVisibility(View.INVISIBLE);
            mensaje.setText("Internet no disponible");
            mensaje.setVisibility(View.VISIBLE);
            button.setVisibility (View.VISIBLE);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        checkConnection();
        db = FirebaseFirestore.getInstance();





        //LinearLayout contentNews = findViewById(R.id.contenedorBotones);
        //TextView nuevaPublicacion = new TextView(this);
        //nuevaPublicacion.setText("Novedades de Spinning");
        //TextView otraPublicacion = new TextView(this);
        //otraPublicacion.setText("Horarios de Spinning");

        //contentNews.addView(nuevaPublicacion);
        //contentNews.addView(otraPublicacion);

        LinearLayout contentAfiche = findViewById(R.id.BannerConteiner);
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


        /*ImageButton homeButton = findViewById(R.id.btn_home);
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
        });*/
    }

   @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            this.uid = currentUser.getUid();
            String email= currentUser.getEmail();
            Boolean verificado = currentUser.isEmailVerified();
            Log.i("firebase email", email);


            if(verificado){
                Toast.makeText(this, "Hola, tu email está verificado.", Toast.LENGTH_SHORT).show();

                this.db.collection("usuarios")
                        .whereEqualTo("uid", uid)
                        .get()
                        .addOnCompleteListener(
                        new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if(task.isSuccessful()){
                                    for (QueryDocumentSnapshot document : task.getResult()){
                                        String id = document.getId();
                                        String nombre = document.getString("nombre");
                                        db.collection("usuarios").document(id).update("verificado",true);
                                        Log.d("TAG", id+"=>"+document.getData());
                                        Log.d("TAG",nombre);

                                    }
                                }
                            }
                        }
                );
            }else{
                String mensajeCompleto = "Hola, tu email " + email + ", necesita ser verificado. Al hacer click en 'Aceptar', recibirá un email para poder realizar esta verificación.";

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View view = getLayoutInflater().inflate(R.layout.custom_dialog, null);
                builder.setView(view);

                TextView textViewMensaje = view.findViewById(R.id.textViewMensaje);
                textViewMensaje.setText(mensajeCompleto);

                AlertDialog dialog = builder.create();
                Button btnAceptar = view.findViewById(R.id.btnAceptar);
                btnAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        currentUser.sendEmailVerification();

                    }
                });


                dialog.show();
            }

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






    public void horarioSpinning(View v){
        Intent intent = new Intent(getApplicationContext(), HorarioSpinningActivity.class);
        String newInfo = getString(R.string.ahora_tenes_clases_de_spinning_todos_los_dias);
        intent.putExtra("newInfo", newInfo);

        startActivity(intent);
    }

    public void horarioCrossfit(View v){
        Intent intent = new Intent(getApplicationContext(), HorarioCrossFitActivity.class);
        String newInfo = getString(R.string.veni_a_cross_fit_a_desafiar_tus_l_mites);
        intent.putExtra("newInfoCross", newInfo);

        startActivity(intent);
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

    public void gap(View v) {

        Intent intent = new Intent(getApplicationContext(), GapInfoActivity.class);

        startActivity(intent);

    }

    public void spinning(View v) {

        Intent intent = new Intent(getApplicationContext(), SpinningInfoActivity.class);

        startActivity(intent);

    }

    public void cross(View v) {

        Intent intent = new Intent(getApplicationContext(), CrossFitInfoActivity.class);

        startActivity(intent);

    }

    public void contacto(View v) {

        Intent intent = new Intent(getApplicationContext(), ContactoActivity.class);

        startActivity(intent);

    }

    public void grillaHorarios(View v) {

        Intent intent = new Intent(getApplicationContext(), GrillaHorarios.class);

        startActivity(intent);

    }

    public void rutinaonline(View v) {

        Intent intent = new Intent(getApplicationContext(), RutinaOnlineActivity.class);

        startActivity(intent);

    }

    public void posteo(View v){
        Intent intent = new Intent(getApplicationContext(), PublicacionActivity.class);
        startActivity(intent);
    }

    public void usuario_info(View v){
        Intent intent = new Intent(getApplicationContext(), UserInfoActivity.class);
        startActivity(intent);
    }
}