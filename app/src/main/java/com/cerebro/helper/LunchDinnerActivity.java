package com.cerebro.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class LunchDinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_dinner);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void gotoPackage1(View v){
        Intent intent = new Intent(this, Package1Activity.class);
        startActivity(intent);
    }

    public void gotoPackage2(View v){
        Intent intent = new Intent(this, Package2Activity.class);
        startActivity(intent);
    }

    public void gotoPackage3(View v){
        Intent intent = new Intent(this, Package3Activity.class);
        startActivity(intent);
    }

    public void gotoPackage4(View v){
        Intent intent = new Intent(this, Package4Activity.class);
        startActivity(intent);
    }


}
