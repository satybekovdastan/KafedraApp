package com.example.dastan.kafedraapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class StudentamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentam);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Студентам");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.kafedra:
//                startActivity(new Intent(StudentamActivity.this, O_kafedre.class));
//                break;
//            case R.id.abiturient:
//                startActivity(new Intent(StudentamActivity.this, StudensActivity.class));
//                break;
//            case R.id.obrazovanie:
//                startActivity(new Intent(StudentamActivity.this,O_kafedre.class));
//                break;
//            case  R.id.pps:
//                startActivity(new Intent(StudentamActivity.this,PrepodActivity.class));
//                break;
            case  R.id.raspicanie:
                startActivity(new Intent(StudentamActivity.this, RacpicanieGlavActivity.class));
                break;

            case  R.id.knu:
               // startActivity(new Intent(StudentamActivity.this, Uspevaimost_activity.class));
                 startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://r.knu.kg")));
                break;

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);

    }
}
