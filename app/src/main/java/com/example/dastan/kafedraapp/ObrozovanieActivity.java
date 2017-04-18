package com.example.dastan.kafedraapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ObrozovanieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obrozovanie);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Оброзование");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.magistr:
                Intent intent = new Intent(ObrozovanieActivity.this, Studenty_kurs_activity.class);
                intent.putExtra("course", 1);
                startActivity(intent);
                break;
            case R.id.bakalavr:
                Intent intent2 = new Intent(ObrozovanieActivity.this, Studenty_kurs_activity.class);
                intent2.putExtra("course", 2);
                startActivity(intent2);
                break;

        }
    }
}
