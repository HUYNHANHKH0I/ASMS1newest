package com.project.asms1.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.adapter.AccountAdapter;

import java.util.ArrayList;

public class ManageAccountActivity extends AppCompatActivity {
    ArrayList accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);

        accountList = new ArrayList();
        AccountAdapter adapter = new AccountAdapter();
        adapter.setAdapterList(accountList);
        ListView accountListView = (ListView)findViewById(R.id.listAccount);
        accountListView.setAdapter(adapter);
        accountListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    public void clickToGoBack(View view) {
        finish();
    }
}