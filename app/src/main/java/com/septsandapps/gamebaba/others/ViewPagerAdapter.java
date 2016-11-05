package com.septsandapps.gamebaba.others;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by talla on 24-10-2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabtitles = new ArrayList<>();

    public void addFragments(Fragment fragments,String titles){
        this.fragments.add(fragments);
        this.tabtitles.add(titles);
    }
   public ViewPagerAdapter(FragmentManager fm){
        super(fm);
   }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles.get(position);
    }
}
