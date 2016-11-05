package com.septsandapps.gamebaba.widgets;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/*
** Created by Venkatesh Uppu in vCommonLib
*/

public class vRecyclerView extends RecyclerView {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ScrollListener scrollListener;

    private int previousTotal = 0;
    private int visibleThreshold = 3;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    public interface ScrollListener {
        void onScrollEnd();
    }

    public vRecyclerView(Context context) {
        super(context);
        recyclerView = this;
    }

    public vRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        recyclerView = this;
    }

    public vRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        recyclerView = this;
    }

    public void setScrollListener(final LinearLayoutManager layoutManager, ScrollListener scroll_Listener){

        this.scrollListener = scroll_Listener;
        this.layoutManager = layoutManager;

        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

                if ( (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                    if ( scrollListener != null ) {
                        scrollListener.onScrollEnd();
                    }
                }


            }
        });

    }
}
