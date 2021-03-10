package com.project.asms1.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        accountList.add("1");
        accountList.add("2");
        accountList.add("3");
        accountList.add("4");
        accountList.add("5");
        AccountAdapter adapter = new AccountAdapter(accountList);
        ListView accountListView = (ListView)findViewById(R.id.listAccount);
        accountListView.setAdapter(adapter);
        accountListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ManageAccountActivity.this, accountListView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void clickToGoBack(View view) {
        finish();
    }
}