package com.project.asms1.presentation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.project.asms1.R;

public class GridViewActivity extends AppCompatActivity {

    private static final String TAG = GridViewActivity.class.getSimpleName();

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        try {
           // getListProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


//    public void getListProduct() throws Exception {
//        NetworkProvider nw = NetworkProvider.self();
//        nw.getService(APIService.class).getProduct().enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//                if(response.isSuccessful()) {
//                    List<Product> products = response.body();
//                    if(products == null) {
//                        System.out.println("ko co du lieu");
//                    }else {
//                        System.out.println("Co du lieu");
//                    }
//                } else {
//                    System.out.println(response.errorBody());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//                Log.e(TAG, t.getMessage());
//            }
//        });
   // }
}