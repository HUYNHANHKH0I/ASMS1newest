package com.project.asms1.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.project.asms1.R;
import com.project.asms1.presentation.ui.store.StoreFragment;

import java.util.ArrayList;

public class PageAdapter implements ListAdapter {
    private int pageNumber;
    LayoutInflater inflater;
    Context context;

    public PageAdapter(Context context, int pageNumber){
        this.pageNumber = pageNumber;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return pageNumber;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.page_adapter, parent, false);
            PageAdapter.ViewHolder viewHolder = new PageAdapter.ViewHolder();
            viewHolder.textItem = (TextView) convertView.findViewById(R.id.txtPageNum);
            convertView.setTag(viewHolder);
        }

        PageAdapter.ViewHolder holder = (PageAdapter.ViewHolder) convertView.getTag();
        holder.textItem.setText(String.valueOf(position + 1));

        holder.textItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "Page " + (position + 1), Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putInt("page",position + 1);
                StoreFragment storeFragment = new StoreFragment();
                storeFragment.setArguments(bundle);
                storeFragment.checkPage();
            }
        });
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return pageNumber;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private class ViewHolder {
        public TextView textItem;
    }
}