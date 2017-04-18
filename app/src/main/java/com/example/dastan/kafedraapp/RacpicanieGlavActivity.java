package com.example.dastan.kafedraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RacpicanieGlavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racpicanie_glav);
    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.course1:
                Intent intent = new Intent(RacpicanieGlavActivity.this, RacpicanieActivity.class);
                intent.putExtra("course", 1);
                startActivity(intent);
                break;
            case R.id.course2:
                Intent intent2 = new Intent(RacpicanieGlavActivity.this, RacpicanieActivity.class);
                intent2.putExtra("course", 2);
                startActivity(intent2);
                break;
            case R.id.course3:
                Intent intent3 = new Intent(RacpicanieGlavActivity.this, RacpicanieActivity.class);
                intent3.putExtra("course", 3);
                startActivity(intent3);
                break;
            case R.id.course4:
                Intent intent4 = new Intent(RacpicanieGlavActivity.this, RacpicanieActivity.class);
                intent4.putExtra("course", 4);
                startActivity(intent4);
                break;
        }
    }

}
