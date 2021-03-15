package com.project.asms1.DAO;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.asms1.R;
import com.project.asms1.model.OrderDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ListAdapter extends BaseAdapter {
    List<OrderDTO> orderDTOList = new ArrayList<>();

    public void setOrderDTOList(List<OrderDTO> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }

    public List<OrderDTO> getOrderDTOList() {
        return orderDTOList;
    }

    public ListAdapter(List<OrderDTO> orderDTOList) {
        this.orderDTOList = orderDTOList;
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
            LayoutInflater inflater = LayoutInflater.from(convertView.getContext());
            inflater.inflate(R.layout.item, parent, false);
        }
        TextView txt_list_item_Id = convertView.findViewById(R.id.txt_item_ID);
        TextView txt_list_item_Date = convertView.findViewById(R.id.txt_item_date);
        TextView txt_list_item_Status = convertView.findViewById(R.id.txt_item_status);
        OrderDTO dto = orderDTOList.get(position);
        txt_list_item_Id.setText(dto.getID());
        txt_list_item_Date.setText(dto.getOrderDate()+" ");
        txt_list_item_Status.setText(dto.getStatus());
        return convertView;
    }
}
