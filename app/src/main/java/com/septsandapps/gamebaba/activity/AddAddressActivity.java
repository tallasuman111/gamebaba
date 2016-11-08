package com.septsandapps.gamebaba.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.septsandapps.gamebaba.R;

public class AddAddressActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText name,mobile_no,pincode,flat,street,city,state;
    Button save;
    String full_name,mobile,pin,building,location,town,province;
    public static final String TAG = "SHAREDPREFFERENCES:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        name = (EditText)findViewById(R.id.full_name);
        mobile_no = (EditText)findViewById(R.id.mobile_number);
        pincode = (EditText)findViewById(R.id.pincode);
        flat = (EditText)findViewById(R.id.flat);
        street = (EditText)findViewById(R.id.street);
        city =(EditText)findViewById(R.id.city);
        state = (EditText)findViewById(R.id.state);
        save = (Button)findViewById(R.id.save);

        full_name = name.getText().toString();
        mobile = mobile_no.getText().toString();
        pin = pincode.getText().toString();
        building = flat.getText().toString();
        location = street.getText().toString();
        town = city.getText().toString();
        province = state.getText().toString();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!full_name.isEmpty() && !mobile.isEmpty()&& !pin.isEmpty() && !building.isEmpty() && !location.isEmpty() && !town.isEmpty() && !province.isEmpty()){
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("UserInfo", 0); // 0 - for private mode
                    String email = pref.getString("email","");
                }
                else{

                    Toast.makeText(getApplicationContext(),"All fields are mandatory", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
