package com.cerebro.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class Package4Activity extends AppCompatActivity {

    TimeCheck timeCheck;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package4);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void orderPackage4(View view){

        mDialog = new Dialog(this);

        timeCheck = new TimeCheck(this);

        if(!timeCheck.checkTime())
        {
            timeCheck.showDialog();
            return ;
        }
        Intent intent = new Intent(Package4Activity.this, HelperCookOrderActivity.class);
        intent.putExtra("pack", "package4");
        startActivity(intent);
    }
}
