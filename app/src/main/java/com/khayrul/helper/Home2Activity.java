package com.khayrul.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class Home2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void goToContactUs(View view) {
        Intent intent = new Intent(this, ContactUsActivity.class);
        startActivity(intent);
    }

    public void goToHomeDelivery(View view) {
        Intent intent = new Intent(this, HomeDeliveryActivity.class);
        startActivity(intent);
    }


    public void goToFreeService(View view) {
        Intent intent = new Intent(this, FreeServiceActivity.class);
        startActivity(intent);

    }

    public void goToAboutUs(View view) {
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }

    public void goToTakeRide(View view) {
        Intent intent = new Intent(this, TakeRideActivity.class);
        startActivity(intent);
    }

    public void goToCatering(View view) {
        Intent intent = new Intent(this, CateringActivity.class);
        startActivity(intent);
    }
}
