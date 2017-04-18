package com.example.dastan.kafedraapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class O_kafedre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_kafedre);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("О кафедре");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.kontacts:
                startActivity(new Intent(O_kafedre.this, KontactyActivity.class));
                break;
            case R.id.stories_kaf:
                startActivity(new Intent(O_kafedre.this, StoriesActivity.class));
                break;
            case R.id.uchebno_metodic:
                startActivity(new Intent(O_kafedre.this, UchebnoMetoducheskiRabActivity.class));
                break;
            case R.id.nauchnye_isledovanie:
                startActivity(new Intent(O_kafedre.this, IsledovRabActivity.class));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
               finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
