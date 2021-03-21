package com.project.asms1.presentation;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.asms1.R;
import com.project.asms1.Utils.PagingScrollListener;
import com.project.asms1.adapter.ScrollingPageAdapter;
import com.project.asms1.config.MyConfig;
import com.project.asms1.daos.UserDAO;
import com.project.asms1.model.User;
import com.project.asms1.network.UserUIService;

import java.util.ArrayList;
import java.util.List;

public class ManageAccountActivity extends AppCompatActivity {
    private ArrayList accountDB;
    private List accountList;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView accountRecyclerView;
    private ScrollingPageAdapter adapter;
    private ProgressBar progressBar;
    private EditText edtSearchAccount;
    private TextView txtEmptyMessage;
    private String searchValue;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);
        initialData();
    }

    public void loadFirstPage() {
        progressBar.setVisibility(View.GONE);
        accountList.clear();
       accountList.addAll(UserDAO.listofuser);
        if(accountList.isEmpty()) {
            txtEmptyMessage.setVisibility(View.VISIBLE);
        } else {
            adapter.addAll(accountList);
            txtEmptyMessage.setVisibility(View.GONE);
        }

        if (accountList.size() != 0) adapter.addLoadingFooter();
        else { isLastPage = true;  }
    }

    public void loadNextPage() {
        accountList.clear();
        accountList.addAll(UserDAO.listofuser);

        adapter.removeLoadingFooter();
        adapter.addAll(accountList);
        if (accountList.size() != 0) adapter.addLoadingFooter();
        else isLastPage = true;
        isLoading = false;
    }
    public void setAdapter() {
        adapter = new ScrollingPageAdapter(this, 1);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        accountRecyclerView.setLayoutManager(linearLayoutManager);
        accountRecyclerView.setAdapter(adapter);
        accountRecyclerView.addOnScrollListener(new PagingScrollListener(linearLayoutManager) {

            @Override
            protected void loadMoreItems() {
                isLoading = true;
                //Increment page index to load the next one
                currentPage++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        UserUIService.getAccount(currentPage, MyConfig.accountperpage,searchString,ManageAccountActivity.this);
                    }
                }, 1000);


            }

            @Override
            public int getTotalPageCount() {
                return totalPages;
            }

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

    @Override
    protected void onResume() {
        super.onResume();
        if (UserDAO.flag) {
            UserDAO.flag = false;
            loadingDataBack();
        }
    }

    public void clickToGoBack(View view) {
        finish();
    }

    public void loadingDataBack() {
        adapter.clear();
        adapter.notifyDataSetChanged();
        isLastPage = false;
        isLoading = false;
        String search = "ALL";
        currentPage = 1;
        UserUIService.getAccount(currentPage, MyConfig.accountperpage,search,ManageAccountActivity.this);
    }

    public void clickToSearchAccount(View view) {
        adapter.clear();
        adapter.notifyDataSetChanged();
        isLastPage = false;
        isLoading = false;
        searchString = edtSearchAccount.getText().toString();
        currentPage = 1;
        UserUIService.getAccount(currentPage, MyConfig.accountperpage,searchString,ManageAccountActivity.this);
    }
    public void initialData() {
        accountList = new ArrayList();
        accountRecyclerView = (RecyclerView) findViewById(R.id.listAccountManageAccount);
        progressBar = (ProgressBar) findViewById(R.id.main_progress_account);
        edtSearchAccount = (EditText) findViewById(R.id.edtSearchAccountManageAccount);
        txtEmptyMessage = (TextView) findViewById(R.id.txtEmptyMessageManageAccount);
        searchValue = "";
        setAdapter();
        currentPage = 1;
        searchString = "ALL";
        UserUIService.getAccount(currentPage, MyConfig.accountperpage,searchString,ManageAccountActivity.this);
    }
}