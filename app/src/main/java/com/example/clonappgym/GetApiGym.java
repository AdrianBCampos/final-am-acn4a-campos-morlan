package com.example.clonappgym;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class Character {
    public String name;
    public String image;
}

class Data {
    public List<Character> results;
}
public class GetApiGym extends AsyncTask<String, Integer, String> {

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        String response ="";
        try {
            response = run(url);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Data respuesta = objectMapper.readValue(response, Data.class);
            //response = respuesta.results.get(0).name;

            List<Character> personajes = respuesta.results;
            for (int i=0; i<personajes.size(); i++){
                Log.i("personajes", personajes.get(i).name);
                Log.i("personajes", personajes.get(i).image);
            }
            response = "funciona";
            /*JSONObject character = new JSONObject(response);
            JSONArray results = (JSONArray)  character.get("results");
            JSONObject character3 = (JSONObject) results.get(2);
            String nameCharacter3 = (String) character3.get("name");
            response = nameCharacter3;*/
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("probando url", s);
    }
}

