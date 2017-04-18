package com.example.dastan.kafedraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

            switch (view.getId()){
                case R.id.line_news:
                    startActivity(new Intent(MainActivity.this, NewsActivity.class));
                    break;
                case R.id.kafedra:
                    startActivity(new Intent(MainActivity.this, O_kafedre.class));
                    break;
                case R.id.abiturient:
                    startActivity(new Intent(MainActivity.this, AbiturientamActivity.class));
                    break;
                case R.id.obrazovanie:
                    startActivity(new Intent(MainActivity.this,ObrozovanieActivity.class));
                    break;
                case  R.id.pps:
                    startActivity(new Intent(MainActivity.this,PrepodActivity.class));
                    break;
                case R.id.nashi_students:
                    startActivity(new Intent(MainActivity.this,StudensActivity.class));
                    break;
                case R.id.students:
                    startActivity(new Intent(MainActivity.this, StudentamActivity.class));
                    break;


        }

    }
}
