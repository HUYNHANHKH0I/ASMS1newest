package com.project.asms1.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.asms1.R;
import com.project.asms1.model.PostDTO;

public class PostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        TextView viewPostID = (TextView) findViewById(R.id.txt_post_ID_post_detail);
        TextView viewPostDate = (TextView) findViewById(R.id.txt_post_date_post_detail);
        TextView viewPostContent = (TextView) findViewById(R.id.txt_post_content_post_detail);
        Intent intent = getIntent();
        PostDTO postDTO = (PostDTO) intent.getSerializableExtra("post");

        viewPostID.setText(postDTO.getId());
        viewPostDate.setText(postDTO.getPostDate().toString());
        viewPostContent.setText(postDTO.getContent());
    }

    public void clickToGoBack(View view) {
        finish();
    }
}