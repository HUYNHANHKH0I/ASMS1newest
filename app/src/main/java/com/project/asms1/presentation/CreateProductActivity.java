package com.project.asms1.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.project.asms1.R;

public class CreateProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
    }

    public void clickToGoBack(View view) {
        finish();
    }

    public void clickToCreateProduct(View view) {
    }
}