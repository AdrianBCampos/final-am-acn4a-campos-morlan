package com.example.clonappgym;


import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


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
        String response = "";
        try {
            response = run(url);
            JSONObject character = new JSONObject(response);
            JSONArray results = (JSONArray) character.get("results");
            JSONObject charater0 = (JSONObject) results.get(0);
        } catch (IOException | JSONException e) {
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