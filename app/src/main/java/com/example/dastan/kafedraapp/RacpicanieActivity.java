package com.example.dastan.kafedraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

import com.pnikosis.materialishprogress.ProgressWheel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RacpicanieActivity extends AppCompatActivity {

    String TAG = "TAG";
    Students vse;
    String im;

    ProgressWheel progressWheel;
    int course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racpicanie);

        progressWheel = (ProgressWheel) findViewById(R.id.progressBarOne);
        progressWheel.setVisibility(View.VISIBLE);
       new ParseTask().execute();

//        Uri uri = Uri.parse("https://content.foto.my.mail.ru/mail/kafedra_itp/10/i-11.jpg");
//        Log.d("IMA", im);
//        Zoom img = new Zoom(this);
//        img.setImageURI(uri);
//        img.setMaxZoom(4f);
//        setContentView(img);
//        Zoom img = new Zoom(this);
//        img.setImageResource(R.drawable.racpi);
//        img.setMaxZoom(4f);
//        setContentView(img);
    }


    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String jsonResult = "";


        @Override
        protected String doInBackground(Void... params) {

            Intent intent = getIntent();
            int course = intent.getIntExtra("course", 0);
            try {
                URL url = new URL("https://warm-inlet-44032.herokuapp.com/api/v1/student/?format=json&course="+course);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder builder = new StringBuilder();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                jsonResult = builder.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return jsonResult;
        }

        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);

            Log.e(TAG, json);

            JSONObject dataJsonObject;
            String secondName;
            //    pbHeaderProgress.setVisibility(View.GONE);
            try {
                dataJsonObject = new JSONObject(json);
                JSONArray menus = dataJsonObject.getJSONArray("objects");
                JSONObject meta = dataJsonObject.getJSONObject("meta");

                JSONObject secondObject = menus.getJSONObject(0);
                secondName = secondObject.getString("fio");
                Log.d(TAG, "Второе имя: " + secondName);

                for (int i = 0; i < menus.length(); i++) {
                    JSONObject menu = menus.getJSONObject(i);
                    Log.d(TAG, "1: ");
                    vse = new Students();
                    Log.d(TAG, "2: ");
                    vse.setFio(menu.getString("fio"));
                    vse.setId(Integer.parseInt(menu.getString("id")));
                    vse.setGroup(menu.getString("group"));
                    vse.setCourse(menu.getString("course"));
                    im = menu.getString("photo_url");
                    vse.setPhoto_students(menu.getString("photo_url"));

                }
                Log.d("IMA1", im);
                imageZoom();
                Log.d("IMA2", im);
                Log.d(TAG, "NET NET dsfsadadsgf: ");
            } catch (JSONException e) {
                e.printStackTrace();

            }
            progressWheel.setVisibility(View.GONE);

        }
    }

    private void imageZoom() {
        Uri uri = Uri.parse(im);
        Log.d("IMA", im);
        Zoom img = new Zoom(this);
        Picasso.with(this).load(im).into(img);
       // img.setImageURI(uri);
        img.setMaxZoom(4f);
        setContentView(img);
    }

}