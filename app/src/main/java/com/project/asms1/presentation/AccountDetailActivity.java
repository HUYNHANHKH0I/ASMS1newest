package com.project.asms1.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.project.asms1.R;
import com.project.asms1.Utils.PopupMessage;

public class AccountDetailActivity extends AppCompatActivity {
    private boolean status;
    EditText edtUsername, edtPassword, edtEmail, edtName;
    Button btnChangeStatus, btnEditAccount;
    CheckBox chkIsAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);

        Intent intent = getIntent();
        Object account = intent.getSerializableExtra("account");
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtUsername.setText("username");
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtPassword.setText("password");
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtEmail.setText("email");
        edtName = (EditText)findViewById(R.id.edtName);
        edtName.setText("name");
        btnChangeStatus =  (Button) findViewById(R.id.btnChangeStatus);
        chkIsAdmin = (CheckBox) findViewById(R.id.chkIsAdmin);
        btnEditAccount = (Button) findViewById(R.id.btnEditAccount);
        status = true;
        setStatus();
    }

    public void clickToGoBack(View view) {
        finish();
    }

    public void clickToEditAccount(View view) {
        if (!status) {
            PopupMessage popup = new PopupMessage();
            popup.showPopupWindow(view,"Account is disabled",false);
        } else if (btnEditAccount.getText().toString().equals("Finish")) {
            setStatus();
            btnEditAccount.setText("Edit Account");
            btnChangeStatus.setEnabled(true);
        } else {
            edtUsername.setFocusable(true);
            edtUsername.setFocusableInTouchMode(true);
            edtUsername.setLongClickable(true);
            edtUsername.setInputType(InputType.TYPE_CLASS_TEXT);

            edtPassword.setFocusable(true);
            edtPassword.setFocusableInTouchMode(true);
            edtPassword.setLongClickable(true);
            edtPassword.setInputType(InputType.TYPE_CLASS_TEXT);

            edtEmail.setFocusable(true);
            edtEmail.setFocusableInTouchMode(true);
            edtEmail.setLongClickable(true);
            edtEmail.setInputType(InputType.TYPE_CLASS_TEXT);

            edtName.setFocusable(true);
            edtName.setFocusableInTouchMode(true);
            edtName.setLongClickable(true);
            edtName.setInputType(InputType.TYPE_CLASS_TEXT);

            chkIsAdmin.setFocusable(true);
            chkIsAdmin.setFocusableInTouchMode(true);
            chkIsAdmin.setClickable(true);

            btnEditAccount.setText("Finish");
            btnChangeStatus.setEnabled(false);

            edtUsername.setFocusedByDefault(true);
        }
    }

    public void clickToChangeAccountStatus(View view) {
        if (status) {
            status = false;
        } else {
            status = true;
        }
        setStatus();
    }
    public void setStatus() {
        if (!status) {
            btnChangeStatus.setText("Activate");
            edtUsername.setEnabled(false);
            edtPassword.setEnabled(false);
            edtEmail.setEnabled(false);
            edtName.setEnabled(false);
            chkIsAdmin.setEnabled(false);
            btnEditAccount.setEnabled(false);
        } else {
            btnChangeStatus.setText("Deactivate");

            edtUsername.setEnabled(true);
            edtUsername.setFocusable(false);
            edtUsername.setFocusableInTouchMode(false);
            edtUsername.setLongClickable(false);
            edtUsername.setInputType(InputType.TYPE_NULL);

            edtPassword.setEnabled(true);
            edtPassword.setFocusable(false);
            edtPassword.setFocusableInTouchMode(false);
            edtPassword.setLongClickable(false);
            edtPassword.setInputType(InputType.TYPE_NULL);

            edtEmail.setEnabled(true);
            edtEmail.setFocusable(false);
            edtEmail.setFocusableInTouchMode(false);
            edtEmail.setLongClickable(false);
            edtEmail.setInputType(InputType.TYPE_NULL);

            edtName.setEnabled(true);
            edtName.setFocusable(false);
            edtName.setFocusableInTouchMode(false);
            edtName.setLongClickable(false);
            edtName.setInputType(InputType.TYPE_NULL);

            chkIsAdmin.setEnabled(true);
            chkIsAdmin.setFocusable(false);
            chkIsAdmin.setFocusableInTouchMode(false);
            chkIsAdmin.setClickable(false);

            btnEditAccount.setEnabled(true);
        }
    }
}