package com.example.dastan.kafedraapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dastan.kafedraapp.DataBase.DataHelper;

import com.pnikosis.materialishprogress.ProgressWheel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Students_course extends AppCompatActivity {
    private RecyclerView rv;
    ArrayList<Students> listVse;
    String TAG = "TAG";
    Students vse;
    RVSAdapter adapter;
    DataHelper dataHelper;
    ProgressWheel linlaHeaderProgress;
    ProgressWheel progressBarOne;
    TextView textSearch;
    int total_count = 1000000;
    private EndlessRecyclerOnScrollListener listener;
    LinearLayout linePovtor;
    TextView textPovtor;
    Button povtor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stunents_course);

//        linlaHeaderProgress = (ProgressWheel) findViewById(R.id.pbHeaderProgress);
//        linlaHeaderProgress.setVisibility(View.GONE);
        progressBarOne = (ProgressWheel) findViewById(R.id.progressBarOne);
        int color = Color.parseColor("#2196f3");
        progressBarOne.setBarColor(color);
        progressBarOne.setVisibility(View.VISIBLE);
//
        progressBarOne.setBarColor(color);


        Log.e("TAG_KATEGORI_SEARCH", "IWTEDI");
        dataHelper = new DataHelper(Students_course.this);

        Intent intent = getIntent();
        String course = intent.getStringExtra("course");
        getSupportActionBar().setTitle(course);

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        LinearLayoutManager llm = new LinearLayoutManager(Students_course.this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        listVse = new ArrayList<>();
        new ParseTask().execute();

    }


    @Override
    public void onResume() {
        super.onResume();

        try {
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                URL url = new URL("https://warm-inlet-44032.herokuapp.com/api/v1/student/?format=json&course=" + course);

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
                total_count = meta.getInt("total_count");

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
                    vse.setPhoto_students(menu.getString("photo_url"));


                    listVse.add(vse);


                }

                progressBarOne.setVisibility(View.GONE);
              //  linlaHeaderProgress.setVisibility(View.GONE);
                adapter=new RVSAdapter(Students_course.this,listVse);
                rv.setAdapter(adapter);
                Log.d("TAG_VSE", listVse.size() + "JSON_PIZDEC_SUKA");
                Log.d(TAG, "NET NET dsfsadadsgf: ");
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("TAG_VSE", listVse.size() + "JSON_PIZDEC");

            }

        }
    }
}






