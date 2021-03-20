package com.project.asms1.presentation;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.asms1.R;
import com.project.asms1.Utils.PagingScrollListener;
import com.project.asms1.adapter.ScrollingPageAdapter;
import com.project.asms1.config.MyConfig;
import com.project.asms1.daos.PostDAO;
import com.project.asms1.model.Post;
import com.project.asms1.network.UserUIService;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class PostListActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button btnChooseDate;
    private ScrollingPageAdapter adapter;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView postRecyclerView;
    private ProgressBar progressBar;

    // Index from which pagination should start (1 is 1st page in our case)
    private static final int PAGE_START = 1;

    // Indicates if footer ProgressBar is shown (i.e. next page is loading)
    private boolean isLoading = false;

    // If current page is the last page (Pagination will stop after this page load)
    private boolean isLastPage = false;

    // total no. of pages to load. Initial load is page 1.
    private int totalPages;

    // indicates the current page which Pagination is fetching.
    private int currentPage = PAGE_START;

    private String searchString ;

    private List postDTOList;
    private ArrayList postDTODB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        btnChooseDate = findViewById(R.id.btnChoosePostDate);
        postRecyclerView = (RecyclerView) findViewById(R.id.listPostPostList);
        progressBar = (ProgressBar) findViewById(R.id.main_progress_post);
        postDTOList = new ArrayList();
        setAdapter();

        //set up button chọn ngày
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String date = day + "/" + month + "/" + year;
        btnChooseDate.setText(date);
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        //TODO: gọi hàm lấy toàn bộ list post
        DateTimeFormatter formatter
                = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(Locale.US);


        currentPage = 1;
        searchString = "ALL";
        UserUIService.getPost(currentPage, MyConfig.postperpage,searchString,PostListActivity.this);
    }

    public void loadFirstPage() {
        progressBar.setVisibility(View.GONE);
        postDTOList.clear();
        postDTOList.addAll(PostDAO.listofPost);
        adapter.addAll(postDTOList);

        if (postDTOList.size() != 0)  adapter.addLoadingFooter();
        else { isLastPage = true;  }
    }

    public void loadNextPage() {
        postDTOList.clear();
        postDTOList.addAll(PostDAO.listofPost);

        adapter.removeLoadingFooter();
        adapter.addAll(postDTOList);
        if (postDTOList.size() != 0) adapter.addLoadingFooter();
        else isLastPage = true;
        isLoading = false;
    }
    private void setAdapter() {
        adapter = new ScrollingPageAdapter(this, 3);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        postRecyclerView.setLayoutManager(linearLayoutManager);
        postRecyclerView.setAdapter(adapter);
        postRecyclerView.addOnScrollListener(new PagingScrollListener(linearLayoutManager) {

            @Override
            protected void loadMoreItems() {
                isLoading = true;
                //Increment page index to load the next one
                currentPage++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        UserUIService.getPost(currentPage, MyConfig.postperpage,searchString,PostListActivity.this);
                    }
                }, 1000);
            }

//            @Override
//            public int getTotalPageCount() {
//                return totalPages;
//            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
    }

    // hàm gọi postlist khi chọn ngày
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = (month + 1) + "/" + dayOfMonth + "/" + year;
        adapter.clear();
        adapter.notifyDataSetChanged();
        isLastPage = false;
        progressBar.setVisibility(View.VISIBLE);
        btnChooseDate.setText(date);
        currentPage = 1;
        searchString = date;
        UserUIService.getPost(currentPage, MyConfig.postperpage,date,PostListActivity.this);
    }

    public void clickToGoBack(View view) {
        finish();
    }
}
