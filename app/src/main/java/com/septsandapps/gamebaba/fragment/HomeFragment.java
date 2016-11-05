package com.septsandapps.gamebaba.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.septsandapps.gamebaba.R;
import com.septsandapps.gamebaba.adapters.ProductAdapter;
import com.septsandapps.gamebaba.backend.Config;
import com.septsandapps.gamebaba.backend.MySingleton;
import com.septsandapps.gamebaba.models.ProductDetails;
import com.septsandapps.gamebaba.widgets.vRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.message;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private List<ProductDetails> productList;
    Context context;
    //Creating Views
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Initializing Views
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);

        //Initializing our productList list
        productList = new ArrayList<>();

        //Calling method to get data
        getData();
    }

    //This method will get data from the web api
    private void getData(){
        //Showing a progress dialog
        final ProgressDialog loading = ProgressDialog.show(getActivity(),"Loading Data", "Please wait...",false,false);

        //Creating a json array request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Config.DATA_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Dismissing progress dialog
                        loading.dismiss();

                        //calling method to parse json array
                        parseData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),"Error...",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsonArrayRequest);
        //Creating request queue
        //RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        //Adding request to the queue
        //requestQueue.add(jsonArrayRequest);
    }

    //This method will parse json data
    private void parseData(JSONArray array){
        for(int i = 0; i<array.length(); i++) {
            ProductDetails productDetails = new ProductDetails();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                productDetails.setId(json.getString(Config.TAG_ID));
                productDetails.setImageUrl(json.getString(Config.TAG_IMAGE_URL));
                productDetails.setGameConsole(json.getString(Config.TAG_CONSOLE));
                productDetails.setGameTitle(json.getString(Config.TAG_NAME));
                productDetails.setPrice(json.getString(Config.TAG_PRICE));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            productList.add(productDetails);
        }

        //Finally initializing our adapter
        adapter = new ProductAdapter(productList, context);

        //Adding adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

}
