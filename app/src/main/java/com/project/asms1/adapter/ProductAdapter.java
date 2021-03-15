package com.project.asms1.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.asms1.R;
import com.project.asms1.presentation.ProductDetailActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.http.Url;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context context;
    private List<Object> productList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txtProductName);
            price = view.findViewById(R.id.txtProductPrice);
            thumbnail = view.findViewById(R.id.txtProductImage);
        }
    }

    public ProductAdapter(Context context, List<Object> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Object product = this.productList.get(position);
        holder.name.setText(product.toString());
        holder.price.setText(String.valueOf(position));

        String urlString = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQe8R6RFlAxVEl7bVdXHe60_7ThYoCSsyiZYA&usqp=CAU";

        Glide.with(context).load(urlString).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, product.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("product", product.toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}