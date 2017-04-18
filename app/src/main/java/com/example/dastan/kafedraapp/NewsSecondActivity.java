package com.example.dastan.kafedraapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsSecondActivity extends AppCompatActivity {

    TextView title, description;
    ImageView image_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_second);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Новости");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Vse vse = (Vse) getIntent().getSerializableExtra("vse");
        title = (TextView) findViewById(R.id.title_news);
        description = (TextView) findViewById(R.id.description);
        image_news = (ImageView) findViewById(R.id.image_news);


        title.setText(vse.getTitle_news());
        description.setText(vse.getDescription_news());


        try {
            if (!TextUtils.isEmpty(vse.getImage_news()))
                Picasso.with(this).load(vse.getImage_news()).error(R.drawable.news_2x).into(image_news);
            else image_news.setImageResource(R.drawable.news_2x);

        } catch (Exception e) {

        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);

    }
}
