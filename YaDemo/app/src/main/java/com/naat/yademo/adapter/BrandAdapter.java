package com.naat.yademo.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.naat.yademo.R;
import com.naat.yademo.databinding.ItemBrandBinding;
import com.naat.yademo.model.Brand;
import com.naat.yademo.viewmodel.ItemBrandViewModel;

import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandAdapterViewHolder> {

    private List<Brand> brandList;

    public BrandAdapter(List<Brand> brandList) {
        this.brandList = brandList;
    }

    @Override
    public BrandAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBrandBinding itemBrandBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_brand,
                parent, false);
        return new BrandAdapterViewHolder(itemBrandBinding);
    }

    @Override
    public void onBindViewHolder(BrandAdapterViewHolder holder, int position) {
        holder.bindBrand(brandList.get(position));
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    public static class BrandAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemBrandBinding itemBrandBinding;

        public BrandAdapterViewHolder(ItemBrandBinding itemBrandBinding) {
            super(itemBrandBinding.brandRelativeContainer);
            this.itemBrandBinding = itemBrandBinding;
        }

        void bindBrand(Brand brand) {
            if (itemBrandBinding.getItemBrandViewModel() == null) {
                itemBrandBinding.setItemBrandViewModel(new ItemBrandViewModel(itemView.getContext(), brand));
            }
        }
    }

}
