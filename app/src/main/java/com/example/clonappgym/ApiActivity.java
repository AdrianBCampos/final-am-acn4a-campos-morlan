package com.example.clonappgym;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        checkConnection();

    }

    public void checkConnectionOnClick(View view) {
        checkConnection();
    }

    public void checkConnection() {
        LinearLayout noInternetMessage = findViewById(R.id.noInternetMessage);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();

        if (networkinfo != null && networkinfo.isConnected()) {
            GetApiGym getApiGym = new GetApiGym();
            getApiGym.execute("https://api-ninjas.com/api/exercises");
            noInternetMessage.setVisibility(View.INVISIBLE);
        } else {
            noInternetMessage.setVisibility(View.VISIBLE);
        }
    }




}