package com.project.asms1.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.Utils.PopupMessage;

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
        EditText edtProductName = (EditText)findViewById(R.id.edtProductName);
        EditText edtProductPrice = (EditText)findViewById(R.id.edtProductPrice);
        EditText edtProductQuantity = (EditText)findViewById(R.id.edtProductQuantity);
        String error = "";
        String name = edtProductName.getText().toString();
        float price = 0;
        int quantity = 0;

        if (name.isEmpty()) {
            error += "Name cannot be empty.\n";
        }
        if (edtProductPrice.getText().toString().isEmpty()) {
            error += "Price cannot be empty\n";
        } else {
            price =  Float.parseFloat(edtProductPrice.getText().toString());
            if (price <= 0 ) {
                error += "Price must be positive.\n";
            }
        }

        if (edtProductQuantity.getText().toString().isEmpty()) {
            error += "Quantity cannot be empty\n";
        } else {
            quantity = Integer.parseInt(edtProductQuantity.getText().toString());
            if (quantity < 0 ) {
                error += "Quantity must be positive.\n";
            }
        }

        if (!error.isEmpty()) {
            final PopupMessage popup = new PopupMessage();
            popup.showPopupWindow(view,error,false);

            ((Button)popup.getPopupView().findViewById(R.id.btnClosePopup)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popup.getPopupWindow().dismiss();
                }
            });
        } else {
            //TODO : insert create product code here
        }
    }
}