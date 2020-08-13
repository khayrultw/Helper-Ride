package com.cerebro.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private  static  int SPLASH_TIME = 4000;
    VideoView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);
        splash = findViewById(R.id.splash_video);
        splash.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.splash2);
        splash.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if(currentUser != null) {
                    Intent splashIntent = new Intent(MainActivity.this, Home2Activity.class);
                    startActivity(splashIntent);
                }
                else {
                    Intent splashIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(splashIntent);
                }
                finish();
            }
        }, SPLASH_TIME);
    }
}
