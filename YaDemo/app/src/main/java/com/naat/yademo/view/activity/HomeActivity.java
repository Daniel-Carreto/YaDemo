package com.naat.yademo.view.activity;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;

import com.naat.yademo.R;
import com.naat.yademo.adapter.HomeAdapter;
import com.naat.yademo.database.YaDatabase;
import com.naat.yademo.databinding.ActivityHomeBinding;
import com.naat.yademo.view.fragment.ContentFragment;

public class HomeActivity extends AppCompatActivity {


    private HomeAdapter homeAdapter = null;
    private ContentFragment boletinFragment;
    private ContentFragment recargasFragment;
    private ContentFragment recaudacionFragment;
    private ContentFragment adminFragment;


    private ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding  = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setSupportActionBar(activityHomeBinding.toolbarMain.toolbar);
        YaDatabase yaDatabase = new YaDatabase(this);
        yaDatabase.initializeDatabase();
        homeAdapter = new HomeAdapter(getSupportFragmentManager());
        boletinFragment = new ContentFragment();
        recargasFragment = new ContentFragment();
        recaudacionFragment = new ContentFragment();
        adminFragment = new ContentFragment();
        homeAdapter.addItem(boletinFragment, getString(R.string.section_boletines));
        homeAdapter.addItem(recargasFragment, getString(R.string.section_recargas));
        homeAdapter.addItem(recaudacionFragment, getString(R.string.section_recaudacion));
        homeAdapter.addItem(adminFragment, getString(R.string.section_admin));
        activityHomeBinding.homeViewpager.setAdapter(homeAdapter);
        activityHomeBinding.homeTablayout.setupWithViewPager(activityHomeBinding.homeViewpager);
    }

    @Override
    public void onBackPressed() {
    }
}
