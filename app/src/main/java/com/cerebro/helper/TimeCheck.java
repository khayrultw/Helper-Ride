package com.cerebro.helper;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeCheck {

    private Dialog mDialog;
    public Button btn;

    public TimeCheck(Context context)
    {
        mDialog = new Dialog(context);
        mDialog.setContentView(R.layout.invalid);
        Window window = mDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        btn = mDialog.findViewById(R.id.close_popup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.cancel();
            }
        });
    }

    public void showDialog()
    {
        mDialog.show();
    }

    public boolean checkTime()
    {
        try {
            String string1 = "09:00:00";
            Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.DATE, 1);


            String string2 = "23:59:59";
            Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);

            Date currentTime = new Date();
            String str = new SimpleDateFormat("HH:mm:ss").format(currentTime);
            Date d = new SimpleDateFormat("HH:mm:ss").parse(str);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(d);
            calendar3.add(Calendar.DATE, 1);

            Date x = calendar3.getTime();
            if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                //checkes whether the current time is between 14:49:00 and 20:11:13.
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}