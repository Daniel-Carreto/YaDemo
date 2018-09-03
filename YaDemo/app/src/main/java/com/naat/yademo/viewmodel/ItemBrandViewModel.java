package com.naat.yademo.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.naat.yademo.model.Brand;
import com.naat.yademo.view.activity.DetailBrandActivity;

public class ItemBrandViewModel extends BaseObservable{

    private Context context;
    private Brand brand;

    public ItemBrandViewModel (Context context, Brand brand){
        this.context = context;
        this.brand = brand;
    }

    public String getTitle(){
        return brand.getName();
    }


    public String getFirstService(){
        return brand.getServices().get(0).getName();
    }

    public String getSecondService(){
        return brand.getServices().get(1).getName();
    }

    public String getThirdService(){
        return brand.getServices().get(2).getName();
    }

    public int getFirstImage(){
        return brand.getServices().get(0).getIcon();
    }

    public int getSecondImage(){
        return brand
                .getServices().get(1).getIcon();
    }

    public int getThirdImage(){
        return brand.getServices().get(2).getIcon();
    }


    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource){
        imageView.setImageResource(resource);
    }

    public void onServiceClick(View v){
        Intent intent = new Intent(context, DetailBrandActivity.class);
        intent.putExtra("brand",brand);
        context.startActivity(intent);
    }

}
