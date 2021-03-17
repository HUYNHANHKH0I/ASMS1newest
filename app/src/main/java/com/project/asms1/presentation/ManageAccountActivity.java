package com.project.asms1.presentation;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.asms1.R;
import com.project.asms1.Utils.PagingScrollListener;
import com.project.asms1.adapter.AccountAdapter;
import com.project.asms1.model.User;

import java.util.ArrayList;
import java.util.List;

public class ManageAccountActivity extends AppCompatActivity {
    ArrayList accountDB;
    List accountList;
    LinearLayoutManager linearLayoutManager;
    RecyclerView accountRecyclerView;
    AccountAdapter adapter;

    ProgressBar progressBar;

    // Index from which pagination should start (1 is 1st page in our case)
    private static final int PAGE_START = 1;

    // Indicates if footer ProgressBar is shown (i.e. next page is loading)
    private boolean isLoading = false;

    // If current page is the last page (Pagination will stop after this page load)
    private boolean isLastPage = false;

    // total no. of pages to load. Initial load is page 1, after which 2 more pages will load.
    private int totalPages = 3;

    // indicates the current page which Pagination is fetching.
    private int currentPage = PAGE_START;

    private final int ROW_PER_PAGE = 10;
    private int startIndex = 0;

    private EditText edtSearchAccount;
    private String searchValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);

        initialData();
        accountList = new ArrayList();

        accountRecyclerView = (RecyclerView) findViewById(R.id.listAccountManageAccount);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);
        edtSearchAccount = (EditText) findViewById(R.id.edtSearchAccountManageAccount);
        searchValue = "";
        setAdapter();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadFirstPage();
            }
        }, 1000);
    }

    private void loadFirstPage() {
        //TODO : insert load data for 1st page here
        progressBar.setVisibility(View.GONE);
        accountList.clear();
        searchValue = edtSearchAccount.getText().toString();
        currentPage = 1;
        int count = 0;
        for (int i = 0; i < accountDB.size(); i++) {
            if (accountDB.get(i).toString().contains(searchValue)) {
                count++;
                if (accountList.size() < ROW_PER_PAGE) {
                    accountList.add(accountDB.get(i));
                    startIndex = i + 1;
                }
            }
        }
        totalPages = (int) Math.ceil( (double) count / ROW_PER_PAGE);
//        System.out.println(totalPages);
//        System.out.println(currentPage);
        adapter.addAll(accountList);

        if (currentPage < totalPages) adapter.addLoadingFooter();
        else {
            isLastPage = true;
            adapter.removeLoadingFooter();
        }
    }

    private void loadNextPage() {
        //TODO : insert load data for next page here
        accountList.clear();
        for (int i = startIndex; i < accountDB.size() && accountList.size() < ROW_PER_PAGE; i++) {
            if (accountDB.get(i).toString().contains(searchValue)) {
                accountList.add(accountDB.get(i));
            }
            startIndex = i + 1;
        }

        adapter.removeLoadingFooter();
        adapter.addAll(accountList);
        if (currentPage != totalPages) adapter.addLoadingFooter();
        else isLastPage = true;
        isLoading = false;
    }
    public void setAdapter() {
        adapter = new AccountAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        accountRecyclerView.setLayoutManager(linearLayoutManager);
        accountRecyclerView.setAdapter(adapter);
        accountRecyclerView.addOnScrollListener(new PagingScrollListener(linearLayoutManager) {

            @Override
            protected void loadMoreItems() {
                isLoading = true;
                //Increment page index to load the next one
                currentPage++;
                loadNextPage();
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

    public void clickToGoBack(View view) {
        finish();
    }

    public void clickToSearchAccount(View view) {
        adapter.clear();
        adapter.notifyDataSetChanged();
        isLastPage = false;
        isLoading = false;
        totalPages = 0;
        loadFirstPage();
    }
    public void initialData() {
        accountDB = new ArrayList();
        User user1 = new User();
        user1.setId("1");
        user1.setName("a1");
        accountDB.add(user1);
        User user2 = new User();
        user2.setId("2");
        user2.setName("a2");
        accountDB.add(user2);
        User user3 = new User();
        user3.setId("3");
        user3.setName("a3");
        accountDB.add(user3);
        User user4 = new User();
        user4.setId("4");
        user4.setName("a4");
        accountDB.add(user4);
        User user5 = new User();
        user5.setId("5");
        user5.setName("a5");
        User user6 = new User();
        user6.setId("6");
        user6.setName("a6");
        accountDB.add(user6);
        User user7 = new User();
        user7.setId("7");
        user7.setName("a7");
        accountDB.add(user7);
        User user8 = new User();
        user8.setId("8");
        user8.setName("a8");
        accountDB.add(user8);
        User user9 = new User();
        user9.setId("9");
        user9.setName("a9");
        accountDB.add(user9);
        User user10 = new User();
        user10.setId("10");
        user10.setName("a10");
        accountDB.add(user10);
        User user11 = new User();
        user11.setId("11");
        user11.setName("a11");
        accountDB.add(user11);
        User user12 = new User();
        user12.setId("12");
        user12.setName("a12");
        accountDB.add(user12);
        User user13 = new User();
        user13.setId("13");
        user13.setName("a13");
        accountDB.add(user13);
        User user14 = new User();
        user14.setId("14");
        user14.setName("a14");
        accountDB.add(user14);
        User user15 = new User();
        user15.setId("15");
        user15.setName("a15");
        accountDB.add(user15);
        User user16 = new User();
        user16.setId("16");
        user16.setName("a16");
        accountDB.add(user16);
        User user17 = new User();
        user17.setId("17");
        user17.setName("a17");
        accountDB.add(user17);
        User user18 = new User();
        user18.setId("18");
        user18.setName("a18");
        accountDB.add(user18);
        User user19 = new User();
        user19.setId("19");
        user19.setName("a19");
        accountDB.add(user19);
        User user20 = new User();
        user20.setId("20");
        user20.setName("a20");
        accountDB.add(user20);
        User user21 = new User();
        user21.setId("21");
        user21.setName("a21");
        accountDB.add(user21);
        User user22 = new User();
        user22.setId("22");
        user22.setName("a22");
        accountDB.add(user22);
    }
}