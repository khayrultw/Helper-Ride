package com.cerebro.helper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HelperCookOrderActivity extends AppCompatActivity {

    EditText userNameText, userPhoneText, userAddressText, userCommentText, userQuanText;

    String userName, userPhone, userAddress, userQuan, userComment;
    String pack = "";

    DatabaseReference databaseRef;

    int totalPrice = 0;

    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_cook_order);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Bundle bundle = getIntent().getExtras();
        pack = bundle.getString("pack");
        //Toast.makeText(this, "hello" + pack, Toast.LENGTH_LONG).show();

        getWindow().setBackgroundDrawableResource(R.drawable.homepage);

        userNameText = findViewById(R.id.user_name);
        userPhoneText = findViewById(R.id.phone_number);
        userAddressText = findViewById(R.id.user_address);
        userCommentText = findViewById(R.id.user_comment);
        userQuanText = findViewById(R.id.user_quan);

        userName = userPhone = userAddress = userComment = "";

        confirmBtn = findViewById(R.id.btn_order);
    }

    public void submit(View view)
    {
        userName = userNameText.getText().toString();
        userPhone = userPhoneText.getText().toString();
        userAddress = userAddressText.getText().toString();
        userComment = userCommentText.getText().toString();
        userQuan = userQuanText.getText().toString();


        if(userName.equals("") || userPhone.equals("") || userAddress.equals("") || userQuan.equals(""))
        {
            Toast.makeText(this,"Please give all information.", Toast.LENGTH_LONG).show();
            return ;
        }

        if(userPhone.length() != 11)
        {
            Toast.makeText(this,"Give a valid phone number.", Toast.LENGTH_LONG).show();
            return ;
        }



        int n = Integer.parseInt(userQuan);
        totalPrice = 0 ;

        if(n == 0)
        {
            Toast.makeText(this,"Quantity cannot be zero.", Toast.LENGTH_LONG).show();
            return ;
        }

        if(pack.equals("package1"))
            totalPrice = n*40;

        else if(pack.equals("package2"))
            totalPrice = n*40;

        else if(pack.equals("package3"))
            totalPrice = n*40;

        else if(pack.equals("package4"))
            totalPrice = n*40;

        else
        {
            Toast.makeText(this,"Something went wrong...", Toast.LENGTH_LONG).show();
            return;
        }

        confirmBtn.setEnabled(false);
        goConfirm();
    }

    public void goConfirm()
    {
        Toast.makeText(HelperCookOrderActivity.this,"Processing....",Toast.LENGTH_LONG).show();
        try {

            databaseRef = FirebaseDatabase.getInstance().getReference("helper-cook");
            String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

            if(userEmail == null)
                userEmail = "unknown";

            //Toast.makeText(HelperCookOrderActivity.this,"You can order....",Toast.LENGTH_LONG).show();

            String id = databaseRef.push().getKey();

            HelperCookOrder order = new HelperCookOrder(id, userName, userPhone, userEmail, userAddress,
                    pack, userComment, userQuan, String.valueOf(totalPrice), "Pending");



            databaseRef.child(id).setValue(order).addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    //Toast.makeText(HelperCookOrderActivity.this,"You cannnnnn....",Toast.LENGTH_LONG).show();
                    if(task.isSuccessful()) {
                        HelperCookOrderActivity.this.finish();
                        Toast.makeText(HelperCookOrderActivity.this, "Order Confirmed", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(HelperCookOrderActivity.this, Home2Activity.class);
                        startActivity(intent);
                    }
                    else {
                        confirmBtn.setEnabled(true);
                        Toast.makeText(HelperCookOrderActivity.this, "Check your internet connection and try again.", Toast.LENGTH_LONG).show();
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
