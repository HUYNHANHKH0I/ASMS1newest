package com.project.asms1.presentation;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.model.Post;

public class PostDetailActivity extends AppCompatActivity {

    private TextView viewPostID,viewPostDate,viewPostContent,viewPostTotalOrder,ordercount;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        initData();

    }

    public void clickToGoBack(View view) {
        finish();
    }

    private void startAnimation(int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start,end);
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ordercount.setText(animation.getAnimatedValue().toString()+"");
                progressBar.setProgress(Integer.parseInt(animation.getAnimatedValue().toString()));

            }
        });
        animator.start();
    }

    private void initData() {
        viewPostID = (TextView) findViewById(R.id.txt_post_ID_post_detail);viewPostDate = (TextView) findViewById(R.id.txt_post_date_post_detail);
        viewPostContent = (TextView) findViewById(R.id.txt_post_content_post_detail);
        ordercount = findViewById(R.id.ordercount);
        progressBar = findViewById(R.id.progresscountbar);
        Intent intent = getIntent();
        Post post = (Post) intent.getSerializableExtra("post");

        viewPostID.setText(post.getID());
        viewPostDate.setText(post.getTime().toString());
        viewPostContent.setText(post.getContent());

        startAnimation(0,post.getTotalOrder());
    }
}