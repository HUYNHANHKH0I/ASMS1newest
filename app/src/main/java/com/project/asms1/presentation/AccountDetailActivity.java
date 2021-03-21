package com.project.asms1.presentation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.project.asms1.R;
import com.project.asms1.Utils.PopupMessage;
import com.project.asms1.adapter.ScrollingPageAdapter;
import com.project.asms1.daos.UserDAO;
import com.project.asms1.model.User;
import com.project.asms1.network.UserUIService;

public class AccountDetailActivity extends AppCompatActivity {
    private boolean status;
    EditText edtUsername, edtEmail, edtName;
    Button btnChangeStatus, btnEditAccount;
    CheckBox chkIsAdmin;
    User account;
    int flag ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);

        Intent intent = getIntent();
        account = (User) intent.getSerializableExtra("user");
        edtUsername = (EditText)findViewById(R.id.edtUsernameAccountDetail);
        edtUsername.setText(account.getUsername());
        edtEmail = (EditText)findViewById(R.id.edtEmailAccountDetail);
        edtEmail.setText(account.getEmail());
        edtName = (EditText)findViewById(R.id.edtNameAccountDetail);
        edtName.setText(account.getName());
        btnChangeStatus =  (Button) findViewById(R.id.btnChangeStatusAccountDetail);
        chkIsAdmin = (CheckBox) findViewById(R.id.chkIsAdminAccountDetail);
        if(account.getRole() == 1) {
            chkIsAdmin.setChecked(true);
        }else {
            chkIsAdmin.setChecked(false);
        }
        btnEditAccount = (Button) findViewById(R.id.btnEditAccountAccountDetail);
        status = account.getStatus() == 1 ? true : false;
        flag = 0;
        setStatus();
    }

    public void clickToGoBack(View view) {
        UserDAO.flag = false;
        finish();
    }

    public void clickToEditAccount(View view) {
         if (btnEditAccount.getText().toString().equals("Finish")) {
             account.setUsername(edtUsername.getText().toString());
             account.setName(edtName.getText().toString());
             account.setEmail(edtEmail.getText().toString());
             account.setRole(chkIsAdmin.isChecked() ? 1 : 2);
             UserUIService.updateUser(AccountDetailActivity.this,account);
        } else {
            edtUsername.setFocusable(true);
            edtUsername.setFocusableInTouchMode(true);
            edtUsername.setLongClickable(true);
            edtUsername.setInputType(InputType.TYPE_CLASS_TEXT);

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
        new AlertDialog.Builder(AccountDetailActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(btnChangeStatus.getText()).setMessage("Are you sure you want to " + btnChangeStatus.getText() + " this account?")
                .setPositiveButton("No", null).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (status) {
                    status = false;
                } else {
                    status = true;
                }
                flag++;
                System.out.println("= " + flag);
                account.setStatus(status ? 1 : 0);
                setStatus();
            }
        }).show();
    }
    public void setStatus() {
        if(flag == 0) {
            if (!status) {
                btnChangeStatus.setText("Activate");
                edtUsername.setEnabled(false);
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
        }else {
            if (!status) {
                btnEditAccount.setEnabled(true);
                btnEditAccount.setText("Finish");
                btnChangeStatus.setText("Activate");
                edtUsername.setEnabled(false);
                edtEmail.setEnabled(false);
                edtName.setEnabled(false);
                chkIsAdmin.setEnabled(false);
            }else {
                btnEditAccount.setEnabled(true);
                btnEditAccount.setText("Finish");
                btnChangeStatus.setText("Deactivate");

                edtUsername.setEnabled(true);
                edtEmail.setEnabled(true);
                edtName.setEnabled(true);
                chkIsAdmin.setEnabled(true);

                edtUsername.setFocusable(true);
                edtUsername.setFocusableInTouchMode(true);
                edtUsername.setLongClickable(true);
                edtUsername.setInputType(InputType.TYPE_CLASS_TEXT);

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
                edtUsername.setFocusedByDefault(true);

            }

        }

    }
}