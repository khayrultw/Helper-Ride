package com.khayrul.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class Package2Activity extends AppCompatActivity {

    TimeCheck timeCheck;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void orderPackage2(View view){
        mDialog = new Dialog(this);

        timeCheck = new TimeCheck(this);

        if(!timeCheck.checkTime())
        {
            timeCheck.showDialog();
            return ;
        }
        Intent intent = new Intent(Package2Activity.this, HelperCookOrderActivity.class);
        intent.putExtra("pack", "package2");
        startActivity(intent);
    }
}
