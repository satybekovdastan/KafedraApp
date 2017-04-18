package com.example.dastan.kafedraapp;


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


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


public class PrepodActivity extends AppCompatActivity {

    private RecyclerView rv;
    ArrayList<Vse> listVse ;
    String TAG="TAG";
    Vse vse;
    RVAdapter adapter;
    DataHelper dataHelper;
    ProgressWheel progressBarOne;
    // ImageView star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepod);
        dataHelper=new DataHelper(this);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("ППС");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        progressBarOne = (ProgressWheel) findViewById(R.id.progressBarOne);
        int color = Color.parseColor("#2196f3");
        progressBarOne.setBarColor(color);
        progressBarOne.setVisibility(View.VISIBLE);
//
        progressBarOne.setBarColor(color);

        rv=(RecyclerView)findViewById(R.id.rvap);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        LinearLayoutManager llm = new LinearLayoutManager(PrepodActivity.this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        listVse=new ArrayList<>();
        new ParseTask().execute();

        //  initializeData();
        //  initializeAdapter();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        listVse=new ArrayList<>();
//        new ParseTask().execute();
//    }
/*private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(listVse);
        rv.setAdapter(adapter);
    }*/

    private void initializeData() {


    }
    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String jsonResult = "";

        @Override
        protected String doInBackground(Void... params) {

            try {
                URL url = new URL("https://warm-inlet-44032.herokuapp.com/api/v1/prepod/?format=json");

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
                JSONObject meta = dataJsonObject.getJSONObject("meta");
              //  total_count = meta.getInt("total_count");

                JSONObject secondObject = menus.getJSONObject(0);
                secondName = secondObject.getString("fio");
                Log.d(TAG, "Второе имя: " + secondName);

                for (int i = 0; i < menus.length(); i++) {
                    JSONObject menu = menus.getJSONObject(i);
                    Log.d(TAG, "1: ");
                    vse = new Vse();
                    Log.d(TAG, "2: ");
                    vse.setFio(menu.getString("fio"));
                    vse.setId(Integer.parseInt(menu.getString("id")));
                    vse.setEmail(menu.getString("email"));
                    vse.setJob_training(menu.getString("job_training"));
                    vse.setPosition(menu.getString("position"));
                    vse.setPhoto_url(menu.getString("photo_url"));
                    vse.setScientific_work(menu.getString("scientific_work"));
                    vse.setWork_programs(menu.getString("work_programs"));


                    listVse.add(vse);


                }
                adapter=new RVAdapter(PrepodActivity.this,listVse);
                rv.setAdapter(adapter);
                progressBarOne.setVisibility(View.GONE);
                Log.d(TAG, "NET NET dsfsadadsgf: ");
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d(TAG, "JSON_PIZDEC");
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);

    }


}