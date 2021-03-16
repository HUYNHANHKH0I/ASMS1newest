package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.adapter.AccountAdapter;

import java.util.ArrayList;

public class ManageAccountActivity extends AppCompatActivity {
    ArrayList accountDB;
    ArrayList accountList;
    AccountAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);

        accountDB = new ArrayList();
        accountDB.add("a1");
        accountDB.add("a2");
        accountDB.add("a3");
        accountDB.add("a4");
        accountDB.add("b5");
        accountDB.add("c6");
        accountDB.add("d7");
        accountDB.add("e8");
        accountDB.add("f9");
        accountDB.add("g10");
        accountDB.add("h11");
        accountDB.add("j12");
        accountDB.add("j13");
        accountDB.add("j14");
        accountDB.add("j15");
        accountDB.add("j16");
        accountDB.add("j17");
        accountDB.add("j18");


        accountList = new ArrayList();
        accountList.addAll(accountDB);
        adapter = new AccountAdapter(accountList);
        ListView accountListView = (ListView)findViewById(R.id.listAccount);
        accountListView.setAdapter(adapter);
        accountListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ManageAccountActivity.this, accountListView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ManageAccountActivity.this, AccountDetailActivity.class);
                intent.putExtra("account",accountListView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }

    public void clickToGoBack(View view) {
        finish();
    }

    public void clickToSearchAccount(View view) {
        String searchValue = ((EditText) (findViewById(R.id.edtSearchAccount))).getText().toString();
        ArrayList searchList = new ArrayList();
        for (int i = 0; i < accountDB.size() ; i++) {
            Object product = accountDB.get(i);
            if (product.toString().contains(searchValue)) {
                searchList.add(product);
            }
        }
        accountList.clear();
        accountList.addAll(searchList);
        adapter.notifyDataSetChanged();
    }
}