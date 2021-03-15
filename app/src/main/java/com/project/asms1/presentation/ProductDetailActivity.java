package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView viewName = (TextView) findViewById(R.id.txtNameProduct);
        TextView viewPrice = (TextView) findViewById(R.id.txtPrice);
        TextView viewCategory = (TextView) findViewById(R.id.txtCategory);
        TextView viewQuantity = (TextView) findViewById(R.id.txtQuantity);

        Intent intent = getIntent();
        Object product = intent.getSerializableExtra("product");

        viewName.setText(product.toString());
        viewPrice.setText(product.toString());
        viewCategory.setText(product.toString());
        viewQuantity.setText(product.toString());

    }

    public void clickToGoBack(View view) {
        finish();
    }
}