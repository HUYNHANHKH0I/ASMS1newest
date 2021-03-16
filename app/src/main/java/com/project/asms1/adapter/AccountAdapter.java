package com.project.asms1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.asms1.R;

import java.util.ArrayList;

public class AccountAdapter extends BaseAdapter {
    ArrayList accountList;

    public AccountAdapter( ArrayList accountList) {
        this.accountList = accountList;
    }

    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int position) {
        return accountList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.account_list_adapter,parent,false);
        }
        Object acc = accountList.get(position);

        ((TextView)convertView.findViewById(R.id.txtId)).setText(acc.toString());

        return convertView;
    }
}
