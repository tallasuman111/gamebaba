package com.septsandapps.gamebaba.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.septsandapps.gamebaba.R;

public class ManageAddressActivity extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayout addaddress;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_address);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        addaddress = (LinearLayout)findViewById(R.id.add_address);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        addaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageAddressActivity.this,AddAddressActivity.class));
            }
        });

    }
}
