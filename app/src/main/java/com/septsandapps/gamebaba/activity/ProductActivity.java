package com.septsandapps.gamebaba.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.septsandapps.gamebaba.R;
import com.septsandapps.gamebaba.backend.Config;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    Spinner spinner;
    String[] qlist;
    List<String> list;
    ImageView consoleimg, gameimg;
    TextView name,price;
    String console_img, game_img, game_name, game_price;

    public static final String TAG = "NAME:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Spinner element
        spinner = (Spinner) findViewById(R.id.qty);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        consoleimg = (ImageView)findViewById(R.id.console_img);
        gameimg = (ImageView)findViewById(R.id.game_img);
        name = (TextView)findViewById(R.id.game_name);
        price = (TextView)findViewById(R.id.game_price);

        console_img = getIntent().getExtras().getString("consoleimg");
        game_img = getIntent().getExtras().getString("gameimg");
        game_name = getIntent().getExtras().getString("name");
        game_price = getIntent().getExtras().getString("price");

        Glide.with(this).load(console_img)
                .placeholder(R.drawable.image_default)
                //.thumbnail(0.5f)
                .error(R.drawable.image_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(consoleimg);

        Glide.with(this).load(game_img)
                .placeholder(R.drawable.image_default)
                //.thumbnail(0.5f)
                .error(R.drawable.image_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(gameimg);
        Log.i(TAG,game_name);
        name.setText(game_name);
        price.setText(game_price);


        qlist = getResources().getStringArray(R.array.qty);
        list = new ArrayList<>();
        for(int i=0 ; i < 30; i++)
        {
            list.add(qlist[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        // Drop down layout style - list view with radio button
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(adapter);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
