package com.project.asms1.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.project.asms1.R;
import com.project.asms1.adapter.ListOrderDetailAdapter;
import com.project.asms1.model.Order;
import com.project.asms1.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailActivity extends AppCompatActivity {
    TextView txt_orderid, txt_orderdate, txt_totalprice, txt_cusname, txt_cusphone,
            txt_cusadd;
    ListView listView;
    ListOrderDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        txt_orderid = findViewById(R.id.txt_order_detail_ID);
        txt_orderdate = findViewById(R.id.txt_order_detail_OrderDate);
        txt_totalprice = findViewById(R.id.txt_order_detail_total_price);
        txt_cusname = findViewById(R.id.txt_order_detail_customer_name);
        txt_cusphone = findViewById(R.id.txt_order_detail_customer_phone);
        txt_cusadd = findViewById(R.id.txt_order_detail_customer_address);
        listView = findViewById(R.id.order_detail_product_list);

        Intent intent = getIntent();
        Order order = (Order) intent.getSerializableExtra("clicked_order");
        List<OrderDetail> orderDetailList = new ArrayList<>();

        //TODO: gọi hàm lấy tất cả orderDetail có id = order nhét vô orderDetailList

        OrderDetail a = new OrderDetail("1","2","3",4,5000);
        OrderDetail b = new OrderDetail("1","2","3",3,6000);
        OrderDetail c = new OrderDetail("1","2","3",1,10000);
        OrderDetail e = new OrderDetail("1","2","3",1,10000);
        OrderDetail f = new OrderDetail("1","2","3",1,10000);
        OrderDetail g = new OrderDetail("1","2","3",1,10000);
        OrderDetail h = new OrderDetail("1","2","3",1,10000);
        orderDetailList.add(a);
        orderDetailList.add(b);
        orderDetailList.add(c);
        orderDetailList.add(e);
        orderDetailList.add(f);
        orderDetailList.add(g);
        orderDetailList.add(h);


        adapter = new ListOrderDetailAdapter();
        adapter.setOrderDetailProductList(orderDetailList);
        listView.setAdapter(adapter);
    }
}