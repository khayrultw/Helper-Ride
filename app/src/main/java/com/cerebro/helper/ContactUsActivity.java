package com.cerebro.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

public class ContactUsActivity extends AppCompatActivity {
    Dialog mDialog;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.popup_address);

        btn = mDialog.findViewById(R.id.close_popup1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.cancel();
            }
        });
    }

    public void makeCall(View view)
    {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:+8801303456780"));
        startActivity(callIntent);
    }

    public void goToFacebookPage(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/HelperRide/"));
        startActivity(browserIntent);
    }

    public void sendMail(View view)
    {
        Intent mailIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("mailto:helperrajshahi@gmail.com"));
        startActivity(mailIntent);
    }

    public void address(View view) {
        mDialog.show();
        Window window = mDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

}
