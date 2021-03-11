package com.project.asms1.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.asms1.R;
import com.project.asms1.Utils.PopupMessage;

public class CreateCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
    }

    public void clickToGoBack(View view) {
        finish();
    }

    public void clickToCreateCategory(View view) {
        EditText edtCategoryName = (EditText)findViewById(R.id.edtCategoryName);
        String name = edtCategoryName.getText().toString();

        if (name.isEmpty()) {
            final PopupMessage popup = new PopupMessage();
            popup.showPopupWindow(view,"Name cannot be empty",false);

            ((Button)popup.getPopupView().findViewById(R.id.btnClosePopup)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popup.getPopupWindow().dismiss();
                }
            });
        } else {
            //TODO : insert create category code here
        }
    }
}