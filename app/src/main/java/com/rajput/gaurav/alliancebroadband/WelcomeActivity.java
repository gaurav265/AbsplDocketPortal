package com.rajput.gaurav.alliancebroadband;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setTheme(R.style.MyStyle);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2500);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent mainIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(mainIntent);
                }

            }
        };

        thread.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}







