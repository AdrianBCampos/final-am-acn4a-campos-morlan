package com.example.clonappgym;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Downloader extends AsyncTask<String, Integer, Bitmap> {
    Bitmap imagenDescargada = null;
    ImageView imageView;
    public Downloader(ImageView imageView) {
        this.imageView = imageView;

    }

    @Override
    public Bitmap doInBackground(String... strings) {
        Log.i("testing","Downloadin");
        try {
            URL descarga = new URL(strings[0]);
            InputStream streamImage = (InputStream) descarga.getContent();
            imagenDescargada = BitmapFactory.decodeStream(streamImage);
        }catch (IOException e){
            e.printStackTrace();
        }
        return imagenDescargada;
    }


    public void opPostExecute(Bitmap bitmap) {

        super.onPostExecute(bitmap);
        if (bitmap == null) return;
        this.imageView.setImageBitmap(bitmap);
    }
}
