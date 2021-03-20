package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.model.Post;

public class PostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        TextView viewPostID = (TextView) findViewById(R.id.txt_post_ID_post_detail);
        TextView viewPostDate = (TextView) findViewById(R.id.txt_post_date_post_detail);
        TextView viewPostContent = (TextView) findViewById(R.id.txt_post_content_post_detail);
        TextView viewPostTotalOrder = (TextView) findViewById(R.id.txt_post_total_order);
        Intent intent = getIntent();
        Post post = (Post) intent.getSerializableExtra("post");

        viewPostID.setText(post.getID());
        viewPostDate.setText(post.getTime().toString());
        viewPostContent.setText(post.getContent());
        viewPostTotalOrder.setText(String.valueOf(post.getTotalOrder()));
    }

    public void clickToGoBack(View view) {
        finish();
    }
}