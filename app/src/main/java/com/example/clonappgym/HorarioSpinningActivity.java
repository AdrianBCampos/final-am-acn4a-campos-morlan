package com.example.clonappgym;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class HorarioSpinningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_spinning);

        Intent intent = this.getIntent();
        if(intent.hasExtra("newInfo")){
            Log.i("TAG", "onCreate: recibimos extra");
        }


    }
}