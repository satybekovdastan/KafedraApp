package com.example.dastan.kafedraapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class StudensActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studens);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Наши студенты");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.course1:
                Intent intent = new Intent(StudensActivity.this, Studenty_kurs_activity.class);
                intent.putExtra("course", 1);
                startActivity(intent);
                break;
            case R.id.course2:
                Intent intent2 = new Intent(StudensActivity.this, Studenty_kurs_activity.class);
                intent2.putExtra("course", 2);
                startActivity(intent2);
                break;
            case R.id.course3:
                Intent intent3 = new Intent(StudensActivity.this, Studenty_kurs_activity.class);
                intent3.putExtra("course", 3);
                startActivity(intent3);
                break;
            case  R.id.course4:
                Intent intent4 = new Intent(StudensActivity.this, Studenty_kurs_activity.class);
                intent4.putExtra("course", 4);
                startActivity(intent4);
                break;


        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);

    }
}
