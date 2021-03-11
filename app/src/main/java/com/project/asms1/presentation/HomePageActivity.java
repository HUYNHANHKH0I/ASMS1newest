package com.project.asms1.presentation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.asms1.R;

import static com.project.asms1.R.*;

public class HomePageActivity extends AppCompatActivity {

    BottomNavigationView footer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home_page);
        footer = findViewById(R.id.navigation);
        footer.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case id.navigation_home:
                        System.out.println("1");
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        return;
                    case R.id.navigation_profile:
                        System.out.println("2");
                        fragment = new UserInforFragment();
                        loadFragment(fragment);
                        return;
                }
                return;
            }
        });

        loadFragment(new HomeFragment());

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        System.out.println("14");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}