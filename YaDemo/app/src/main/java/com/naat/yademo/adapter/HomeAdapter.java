package com.naat.yademo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends FragmentPagerAdapter {

    private final List<Fragment> listFragments=new ArrayList<>();
    private final List<String> listNameFragments=new ArrayList<>();


    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addItem(Fragment fragment, String title){
        listFragments.add(fragment);
        listNameFragments.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listNameFragments.get(position);
    }
}
