package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.adapter.CategoryAdapter;
import com.project.asms1.adapter.ProductAdapter;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;

public class ManageStoreActivity extends AppCompatActivity {
    ArrayList categoryList;
    ArrayList productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_store);

        TwoWayView categoryView = (TwoWayView) findViewById(R.id.listCategory);
        categoryList = new ArrayList();
        categoryList.add("aBCDASDAS");
        categoryList.add("b");
        categoryList.add("c");
        categoryList.add("d");
        categoryList.add("e");
        categoryList.add("f");
        categoryList.add("g");
        categoryList.add("h");
        CategoryAdapter adapter = new CategoryAdapter(this,categoryList);
        categoryView.setAdapter(adapter);

        ListView productView = findViewById(R.id.listProduct);

        productList = new ArrayList();
        productList.add("a");
        productList.add("b");
        productList.add("c");

        ProductAdapter productAdapter = new ProductAdapter(productList);
        productView.setAdapter(productAdapter);
        productView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ManageStoreActivity.this,  ProductDetailActivity.class);
                intent.putExtra("product",productView.getItemIdAtPosition(position));
                startActivity(intent);
            }
        });

    }


    public void clickToGoBack(View view) {
        finish();
    }

    public void clickToGoToCreateCategory(View view) {
        Intent intent = new Intent(ManageStoreActivity.this,  CreateCategoryActivity.class);
        startActivity(intent);
    }

    public void clickToGoToCreateProduct(View view) {
//        Intent intent = new Intent(ManageStoreActivity.this,  CreateProductActivity.class);
//        startActivity(intent);
    }
}