package com.septsandapps.gamebaba.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.septsandapps.gamebaba.R;

public class YourAccountActivity extends AppCompatActivity {

    LinearLayout address,creditcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_account);

        address = (LinearLayout)findViewById(R.id.manage_address);
        creditcard = (LinearLayout)findViewById(R.id.add_credit);

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YourAccountActivity.this,ManageAddressActivity.class));
            }
        });
    }
}
