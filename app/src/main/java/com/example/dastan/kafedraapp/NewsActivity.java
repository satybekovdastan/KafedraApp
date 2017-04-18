package com.example.dastan.kafedraapp;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

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
import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    private RecyclerView rv;
    ArrayList<Vse> listVse;
    String TAG = "TAG";
    Vse vse;
    RVNewsAdapter adapter;
    DataHelper dataHelper;
    ProgressWheel progressBarOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // ImageView star;
        dataHelper = new DataHelper(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Новости");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        progressBarOne = (ProgressWheel) findViewById(R.id.progressBarOne);
        int color = Color.parseColor("#2196f3");
        progressBarOne.setBarColor(color);
        progressBarOne.setVisibility(View.VISIBLE);
//
        progressBarOne.setBarColor(color);

        rv = (RecyclerView) findViewById(R.id.rvnews);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        LinearLayoutManager llm = new LinearLayoutManager(NewsActivity.this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        listVse = new ArrayList<>();
        new NewsActivity.ParseTask().execute();

    }


    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String jsonResult = "";

        @Override
        protected String doInBackground(Void... params) {

            try {
                URL url = new URL("https://warm-inlet-44032.herokuapp.com/api/v1/news/?format=json");

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

            try {
                dataJsonObject = new JSONObject(json);
                JSONArray menus = dataJsonObject.getJSONArray("objects");

                JSONObject secondObject = menus.getJSONObject(0);
                secondName = secondObject.getString("title");
                Log.d(TAG, "Второе имя: " + secondName);

                for (int i = 0; i < menus.length(); i++) {
                    JSONObject menu = menus.getJSONObject(i);
                    Log.d(TAG, "1: ");
                    vse = new Vse();
                    Log.d(TAG, "2: ");
                    vse.setTitle_news(menu.getString("title"));
                    vse.setDescription_news(menu.getString("description"));
                    vse.setImage_news(menu.getString("photo_url"));


                    listVse.add(vse);


                }
                adapter = new RVNewsAdapter(NewsActivity.this, listVse);
                rv.setAdapter(adapter);
                progressBarOne.setVisibility(View.GONE);
                Log.d(TAG, "NET NET dsfsadadsgf: ");
            } catch (JSONException e) {
                e.printStackTrace();

            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            finish();
        return super.onOptionsItemSelected(item);

    }
}

