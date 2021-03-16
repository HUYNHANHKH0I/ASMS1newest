package com.project.asms1.presentation;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.project.asms1.R;
import com.project.asms1.daos.ListAdapter;
import com.project.asms1.model.OrderDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderListActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button btnChooseDate;
    private ListView listView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        btnChooseDate = findViewById(R.id.btnChooseDate);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String date = day + "/" + month + "/" + year;
        btnChooseDate.setText(date);
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getFragmentManager(), "DatePicker");
            }
        });
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        OrderDTO a = null;
        OrderDTO b = null;
        try {
            a = new OrderDTO("1","2","3","4","5",1, new Date(sdf.parse("15/3/2021").getDate()));
            b = new OrderDTO("1","2","3","4","5",1, new Date(sdf.parse("14/3/2021").getDate()));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //set listview
        listView = findViewById(R.id.orderListView);
        adapter = new ListAdapter();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(a);
        orderDTOList.add(b);
        adapter.setOrderDTOList(orderDTOList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
        btnChooseDate.setText(date);
    }


}