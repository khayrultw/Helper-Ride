package com.khayrul.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class CateringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void goToHelperCook(View view) {
        Intent intent = new Intent(this, HelperCookActivity.class);
        startActivity(intent);
    }

    public void unAvailable(View view) {
        Intent intent = new Intent(this, TakeRideActivity.class);
        startActivity(intent);
    }
}
