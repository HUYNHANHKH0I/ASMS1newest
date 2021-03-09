package com.project.asms1.presentation;

import android.opengl.EGLExt;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.adapter.AccountAdapter;

import java.util.ArrayList;

public class ManageStoreActivity extends AppCompatActivity {
    ArrayList categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_store);

        GridView list = findViewById(R.id.listItem);

        categoryList = new ArrayList();
        categoryList.add(1);
        categoryList.add(2);
        categoryList.add(3);
        categoryList.add(4);
        categoryList.add(5);
        categoryList.add(6);
        categoryList.add(7);
        categoryList.add(8);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,categoryList);
        list.setAdapter(adapter);
    }


    public void clickToGoBack(View view) {
    }
}