package com.example.isaac.gamedraw.FragmentActivity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.isaac.gamedraw.R;
import com.example.isaac.gamedraw.SelectSportActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, SelectSportActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
