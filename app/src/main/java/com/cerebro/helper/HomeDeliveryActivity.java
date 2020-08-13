package com.cerebro.helper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeDeliveryActivity extends AppCompatActivity {

    EditText userNameText, userPhoneText, userAddressText, userOrderText;

    String userName, userPhone, userAddress, userOrder;

    DatabaseReference databaseRef;

    Dialog mDialog;
    TextView confirmMsg;
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_delivery);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setBackgroundDrawableResource(R.drawable.homepage);

        userNameText = findViewById(R.id.user_name);
        userPhoneText = findViewById(R.id.phone_number);
        userAddressText = findViewById(R.id.user_address);
        userOrderText = findViewById(R.id.order);

        userName = userPhone = userAddress = userOrder = "";

        mDialog = new Dialog(this);
    }

    public void submit(final View view)
    {
        userName = userNameText.getText().toString();
        userPhone = userPhoneText.getText().toString();
        userAddress = userAddressText.getText().toString();
        userOrder = userOrderText.getText().toString();


        if(userName.equals("") || userPhone.equals("") || userAddress.equals("") || userOrder.equals(""))
        {
            Toast.makeText(this,"Please give all information.", Toast.LENGTH_LONG).show();
            return ;
        }

        if(userPhone.length() != 11)
        {
            Toast.makeText(this,"Give a valid phone number.", Toast.LENGTH_LONG).show();
            return ;
        }


        mDialog.setContentView(R.layout.popup_msg);
        confirmBtn = mDialog.findViewById(R.id.confirm_order);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmBtn.setEnabled(false);
                confirmOrder();
            }
        });

        mDialog.show();

        Window window = mDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        confirmMsg = mDialog.findViewById(R.id.popup_text);
        String txt = "Phone: " + userPhone + "\nOrder:\n" + userOrder;
        confirmMsg.setText(txt);

    }

    public void confirmOrder()
    {
        Toast.makeText(HomeDeliveryActivity.this,"Processing....",Toast.LENGTH_LONG).show();
        try {

            databaseRef = FirebaseDatabase.getInstance().getReference("home-delivery-order");
            String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

            if(userEmail == null)
                userEmail = "unknown";

            //Toast.makeText(HomeDeliveryActivity.this,"You can order....",Toast.LENGTH_LONG).show();

            String id = databaseRef.push().getKey();

            HomeDeliveryOrder order = new HomeDeliveryOrder(id, userName, userPhone, userEmail, userAddress, userOrder, "Pending");



            databaseRef.child(id).setValue(order).addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    //Toast.makeText(HomeDeliveryActivity.this,"You cannnnnn....",Toast.LENGTH_LONG).show();
                    if(task.isSuccessful()) {
                        HomeDeliveryActivity.this.finish();
                        Toast.makeText(HomeDeliveryActivity.this, "Order Confirmed", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(HomeDeliveryActivity.this, Home2Activity.class);
                        startActivity(intent);
                    }
                    else {
                        confirmBtn.setEnabled(true);
                        Toast.makeText(HomeDeliveryActivity.this, "Check your internet connection and try again.", Toast.LENGTH_LONG).show();
                    }
                }

            });

        }catch (Exception e)
        {
            confirmBtn.setEnabled(true);
            Toast.makeText(this,"Sorry order something wrong.",Toast.LENGTH_LONG).show();
        }

    }

}
