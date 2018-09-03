package com.naat.yademo.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.naat.yademo.R;
import com.naat.yademo.databinding.ActivityDetailBrandBinding;


public class DetailBrandActivity extends AppCompatActivity {
    ActivityDetailBrandBinding activityDetailBrandBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBrandBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_brand);
        setSupportActionBar(activityDetailBrandBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
