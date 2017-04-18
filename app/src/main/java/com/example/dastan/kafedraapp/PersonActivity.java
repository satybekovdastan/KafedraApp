package com.example.dastan.kafedraapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PersonActivity extends AppCompatActivity {


    ImageView photo;
    TextView fio, email, job, position, work , work_programs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("ППС");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Vse vse = (Vse) getIntent().getSerializableExtra("vse");
        fio = (TextView) findViewById(R.id.fio);
        email = (TextView) findViewById(R.id.email);
        job = (TextView) findViewById(R.id.job_training);
        position = (TextView) findViewById(R.id.position);
        work = (TextView) findViewById(R.id.work);
        work_programs = (TextView) findViewById(R.id.work_programs);
        photo = (ImageView) findViewById(R.id.photo);


        fio.setText(vse.getFio());
        email.setText(vse.getEmail());
        job.setText(vse.getJob_training());
        position.setText(vse.getPosition());
        work.setText(vse.getScientific_work());
        work_programs.setText(vse.getWork_programs());

        try {
            if (!TextUtils.isEmpty(vse.getPhoto_url()))
                Picasso.with(this).load(vse.getPhoto_url()).error(R.drawable.place_holder).into(photo);
            else photo.setImageResource(R.drawable.place_holder);

        } catch (Exception e) {

        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);

    }




}
