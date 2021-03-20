package com.project.asms1.presentation;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.adapter.PostAdapter;
import com.project.asms1.model.PostDTO;
import com.project.asms1.presentation.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PostListActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button btnChooseDate;
    private ListView listView;
    private PostAdapter adapter;

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
        btnChooseDate.setText(date);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        btnChooseDate = findViewById(R.id.btnChoosePostDate);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String date = day + "/" + month + "/" + year;
        btnChooseDate.setText(date);
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new PostDatePickerFragment();
                dialogFragment.show(getFragmentManager(), "DatePicker");
            }
        });
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        PostDTO a = null;
        PostDTO b = null;
        PostDTO c = null;
        PostDTO d = null;
        PostDTO g = null;
        PostDTO f = null;
        try {
            a = new PostDTO("1", "2", "3", 1, new Date(sdf.parse("15/3/2021").getDate()));
            b = new PostDTO("1", "2", "3", 1, new Date(sdf.parse("14/3/2021").getDate()));
            c = new PostDTO("1", "2", "3", 1, new Date(sdf.parse("13/3/2021").getDate()));
            d = new PostDTO("1", "2", "3", 1, new Date(sdf.parse("12/3/2021").getDate()));
            g = new PostDTO("1", "2", "3", 1, new Date(sdf.parse("11/3/2021").getDate()));
            f = new PostDTO("1", "2", "3", 1, new Date(sdf.parse("10/3/2021").getDate()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        listView = findViewById(R.id.postListView);
        adapter = new PostAdapter();
        List<PostDTO> postDTOList = new ArrayList<>();
        postDTOList.add(a);
        postDTOList.add(b);
        postDTOList.add(c);
        postDTOList.add(d);
        postDTOList.add(g);
        postDTOList.add(f);
        adapter.setPostDTOList(postDTOList);
        listView.setAdapter(adapter);
    }
}
