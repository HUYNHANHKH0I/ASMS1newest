package com.project.asms1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.asms1.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ArrayList productList;

    public ProductAdapter(ArrayList productList) {
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.product_list_adapter,parent,false);
        }
        Object acc = productList.get(position);

        ((TextView)convertView.findViewById(R.id.txtProductName)).setText(acc.toString());


        return convertView;
    }
}
