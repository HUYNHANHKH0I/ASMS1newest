package com.project.asms1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.asms1.R;
import com.project.asms1.model.Order;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    List<Order> orderDTOList = new ArrayList<>();

    public void setOrderDTOList(List<Order> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }

    public List<Order> getOrderDTOList() {
        return orderDTOList;
    }



    @Override
    public int getCount() {
        return orderDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_order_list, parent, false);
        }
        TextView txt_list_item_Id = convertView.findViewById(R.id.txt_item_ID);
        TextView txt_list_item_Date = convertView.findViewById(R.id.txt_item_date);
        TextView txt_list_item_Status = convertView.findViewById(R.id.txt_item_status);
        Order dto = orderDTOList.get(position);
        txt_list_item_Id.setText(dto.getID());
        txt_list_item_Date.setText(dto.getOrderDate()+" ");
        txt_list_item_Status.setText(dto.getStatus()+"");
        return convertView;
    }
}
