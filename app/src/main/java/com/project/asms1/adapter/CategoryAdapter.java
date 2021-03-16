package com.project.asms1.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.project.asms1.R;
import com.project.asms1.daos.ProductDAO;
import com.project.asms1.model.Category;
import com.project.asms1.model.Product;
import com.project.asms1.network.UserUIService;
import com.project.asms1.presentation.ui.store.StoreFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reale on 2/22/2017.
 */


public class CategoryAdapter implements ListAdapter {
    private List<Category> listData;
    LayoutInflater inflater;
    Context context;
    StoreFragment storeFragment;

    public CategoryAdapter(Context context, List<Category> listData, StoreFragment storeFragment){
        this.listData = listData;
        this.context = context;
        this.storeFragment = storeFragment;
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
        if(listData != null && !listData.isEmpty()){
            return listData.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
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
            convertView = inflater.inflate(R.layout.category_list_adapter, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textItem = (TextView) convertView.findViewById(R.id.txtCategoryName);
            convertView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.textItem.setText(listData.get(position).getName());

        holder.textItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDAO.currentCategory = listData.get(position).getId();
                Toast.makeText(parent.getContext(), ProductDAO.currentCategory, Toast.LENGTH_SHORT).show();
                UserUIService.changeCategory(1, listData.get(position).getId(),storeFragment);
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
        return listData.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private class ViewHolder {
        public LinearLayout layout;
        public TextView textItem;
    }
}

