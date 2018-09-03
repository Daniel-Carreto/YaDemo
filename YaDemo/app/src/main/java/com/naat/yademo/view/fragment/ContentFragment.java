package com.naat.yademo.view.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.naat.yademo.R;
import com.naat.yademo.adapter.BrandAdapter;
import com.naat.yademo.database.YaDatabase;
import com.naat.yademo.databinding.FragmentContentBinding;
import com.naat.yademo.model.Brand;
import com.naat.yademo.model.Service;

import java.util.ArrayList;
import java.util.List;


public class ContentFragment extends Fragment  implements android.support.v7.widget.SearchView.OnQueryTextListener{

    private List<Brand> brands;
    private List<Service> services;
    private BrandAdapter brandAdapter;
    private List<Brand> searchList;

    FragmentContentBinding fragmentContentBinding = null;
    public ContentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().finish();
                return true;
            case R.id.action_search:
                android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) item.getActionView();
                searchView.setOnQueryTextListener(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentContentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_content,container,false);
        return fragmentContentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        YaDatabase yaDatabase = new YaDatabase(getActivity());
        brands = yaDatabase.getBrandList();
        for (Brand brand:
             brands) {
            services = yaDatabase.getServiceList(brand.getId());
            brand.setServices(services);
        }
        loadAdapter(brands);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchList = new ArrayList<>();
        for (Brand brand:
             brands) {
            if(brand.getName().toLowerCase().contains(newText)){
                searchList.add(brand);
            }
        }
        loadAdapter(searchList);
        return false;
    }

    private void loadAdapter(List<Brand> brands){
        brandAdapter = new BrandAdapter(brands);
        fragmentContentBinding.contentRecyclerview.setAdapter(brandAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentContentBinding.contentRecyclerview.setLayoutManager(llm);
    }
}
