package com.septsandapps.gamebaba.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.septsandapps.gamebaba.R;
import com.septsandapps.gamebaba.activity.HomeActivity;
import com.septsandapps.gamebaba.backend.Config;
import com.septsandapps.gamebaba.backend.CustomVolleyRequest;
import com.septsandapps.gamebaba.fragment.HomeFragment;
import com.septsandapps.gamebaba.models.ProductDetails;

import java.util.List;

/**
 * Created by talla on 30-10-2016.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ImageLoader imageLoader;
    Context context;
    List<ProductDetails> itemsList;
    public static final String TAG = "MESSAGE:";

    public ProductAdapter(List<ProductDetails> itemsList, Context context){
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_productlist, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ProductDetails productDetails = itemsList.get(position);
        //imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        //imageLoader.get(productDetails.getImageUrl(), ImageLoader.getImageListener(viewHolder.gameImage, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        if(productDetails != null)
        {
            Glide.with(context).load(Config.IMAGE_URL + productDetails.getGameConsole())
                    .placeholder(R.drawable.image_default)
                    //.thumbnail(0.5f)
                    .error(R.drawable.image_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.console);

            // Loading profile image
            Log.i(TAG,Config.IMAGE_URL + productDetails.getImageUrl());
            Glide.with(context).load(Config.IMAGE_URL + productDetails.getImageUrl())
                    .placeholder(R.drawable.image_default)
                    //.thumbnail(0.5f)
                    .error(R.drawable.image_default)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.gameImage);

            viewHolder.gameName.setText(productDetails.getGameTitle());
            viewHolder.price.setText(productDetails.getPrice());
            viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView console;
        ImageView gameImage;
        TextView gameName;
        TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            console = (ImageView)itemView.findViewById(R.id.console_img);
            gameImage = (ImageView) itemView.findViewById(R.id.game_image);
            gameName = (TextView)itemView.findViewById(R.id.game_title);
            price = (TextView)itemView.findViewById(R.id.game_price);

        }
    }

}
