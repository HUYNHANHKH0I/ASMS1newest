package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.adapter.ListOrderDetailAdapter;
import com.project.asms1.model.Order;
import com.project.asms1.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailActivity extends AppCompatActivity {
    TextView txt_orderid, txt_orderdate, txt_totalprice, txt_cusname, txt_cusphone,
            txt_cusadd,txt_cusemail;
    ListView listView;
    ListOrderDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initData();
    }

    private void initData() {
        txt_orderid = findViewById(R.id.txt_order_detail_ID);
        txt_orderdate = findViewById(R.id.txt_order_detail_OrderDate);
        txt_totalprice = findViewById(R.id.txt_order_detail_total_price);
        txt_cusname = findViewById(R.id.txt_order_detail_customer_name);
        txt_cusphone = findViewById(R.id.txt_order_detail_customer_phone);
        txt_cusadd = findViewById(R.id.txt_order_detail_customer_address);
        txt_cusemail= findViewById(R.id.txt_order_detail_customer_email);
        listView = findViewById(R.id.order_detail_product_list);

        Intent intent = getIntent();
        Order order = (Order) intent.getSerializableExtra("clicked_order");

        txt_orderid.setText(order.getID());
        txt_orderdate.setText(order.getOrderDate().toString());
        txt_totalprice.setText(String.valueOf(order.getTotalPrice()));
        txt_cusname.setText(order.getCustomerinfo().getName());
        txt_cusphone.setText(order.getCustomerinfo().getPhoneNumber());
        txt_cusadd.setText(order.getCustomerinfo().getAddress());
        txt_cusemail.setText(order.getCustomerinfo().getEmail());


        adapter = new ListOrderDetailAdapter();
        adapter.setOrderDetailProductList(order.getOrderdetaillist());
        listView.setAdapter(adapter);
    }

    public void clickToGoBack(View view) {
        finish();
    }
}