package com.project.asms1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.asms1.R;
import com.project.asms1.model.OrderDTO;
import com.project.asms1.model.PostDTO;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends BaseAdapter {
    List<PostDTO> postDTOList = new ArrayList<>();

    public List<PostDTO> getPostDTOList() {
        return postDTOList;
    }

    public void setPostDTOList(List<PostDTO> postDTOList) {
        this.postDTOList = postDTOList;
    }

    @Override
    public int getCount() {
        return postDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return postDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.postitem, parent, false);
        }
        TextView txt_list_post_Id = convertView.findViewById(R.id.txt_post_ID);
        TextView txt_list_post_Date = convertView.findViewById(R.id.txt_post_date);
        TextView txt_list_post_Status = convertView.findViewById(R.id.txt_post_status);
        PostDTO dto = postDTOList.get(position);
        txt_list_post_Id.setText(dto.getId());
        txt_list_post_Date.setText(dto.getPostDate()+" ");
        txt_list_post_Status.setText(dto.getStatus()+"");
        return convertView;
    }
}
