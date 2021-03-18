package com.project.asms1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.asms1.R;
import com.project.asms1.model.OrderDetail;
import com.project.asms1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListOrderDetailAdapter extends BaseAdapter {
    List<OrderDetail> OrderDetailProductList = new ArrayList<>();

    public void setOrderDetailProductList(List<OrderDetail> OrderDetailProductList) {
        this.OrderDetailProductList = OrderDetailProductList;
    }

    public List<OrderDetail> getOrderDTOList() {
        return OrderDetailProductList;
    }


    @Override
    public int getCount() {
        return OrderDetailProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return OrderDetailProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_order_detail_product_list, parent, false);
        }
        ImageView img = convertView.findViewById(R.id.order_detail_product_image);
        TextView txt_list_item_Name = convertView.findViewById(R.id.order_detail_product_name);
        TextView txt_list_item_Quantity = convertView.findViewById(R.id.order_detail_product_quantity);
        TextView txt_list_item_Price = convertView.findViewById(R.id.order_detail_product_price);

        OrderDetail orderDetail = OrderDetailProductList.get(position);
        
        //TODO: gọi hàm lấy product có product_Id = product_Id trong OrderDetail rồi nhét vô object product

        Glide.with(parent.getContext()).load(orderDetail.getImgurl()).error(R.drawable.ic_baseline_image_24).into(img);
        txt_list_item_Name.setText(orderDetail.getProductname());
        txt_list_item_Quantity.setText("x" + orderDetail.getQuantity()+"");
        txt_list_item_Price.setText(orderDetail.getPrice()+ "$");
        return convertView;
    }
}
