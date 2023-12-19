package com.example.clonappgym;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;

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

/*class Exercise {
    public String name;

}

class Data {
    public List<Exercise> results;
}*/
public class GetApiGym extends AsyncTask<String, Integer, JSONArray> {

    OkHttpClient client = new OkHttpClient();

    JSONArray run(String url) throws IOException, JSONException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String jsonResponse = response.body().string();
            return new JSONArray(jsonResponse);
        }
    }

    @Override
    protected JSONArray doInBackground(String... strings) {
        String url = strings[0];
        JSONArray jsonArray = null;
        try {
            jsonArray = run(url);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        super.onPostExecute(jsonArray);
        if (jsonArray != null) {

            try {



                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    String nombre = item.getString("name");
                    String descripcion = item.getString("instructions");

                    Log.i("GetApiGym", "Nombre: " + nombre);
                    Log.i("GetApiGym", "Descripción: " + descripcion);


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {

            Log.e("GetApiGym", "El array JSON es nulo");
        }
    }
}
