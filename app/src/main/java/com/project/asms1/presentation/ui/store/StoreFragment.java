package com.project.asms1.presentation.ui.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.asms1.R;
import com.project.asms1.adapter.CategoryAdapter;
import com.project.asms1.adapter.PageAdapter;
import com.project.asms1.adapter.ProductAdapter;
import com.project.asms1.config.MyConfig;
import com.project.asms1.daos.ProductDAO;
import com.project.asms1.daos.StoreDAO;
import com.project.asms1.model.Category;
import com.project.asms1.model.Product;
import com.project.asms1.model.Store;
import com.project.asms1.presentation.CreateCategoryActivity;
import com.project.asms1.presentation.CreateProductActivity;
import com.project.asms1.presentation.ProductDetailActivity;

;import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;
import java.util.List;

public class StoreFragment extends Fragment {
    List<Category> categoryList;
    List<Product> productList;
    private int numberOfPage;
    private int curentPage = 1;
    private ProductAdapter productAdapter;
    private PageAdapter pageAdapter;
    private View root;

    RecyclerView productView;

    private StoreViewModel storeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        storeViewModel =
                new ViewModelProvider(this).get(StoreViewModel.class);
        root = inflater.inflate(R.layout.fragment_store, container, false);

        storeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        TwoWayView categoryView = (TwoWayView) root.findViewById(R.id.listCategory);
        categoryList = ProductDAO.listOfCategory;
        CategoryAdapter adapter = new CategoryAdapter(getContext(),categoryList,this);
        categoryView.setAdapter(adapter);

        productView = root.findViewById(R.id.list_product);
        productList = ProductDAO.listOfProduct;
        setAdapter();

        ((Button)root.findViewById(R.id.btnGoToCreateCategory)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),  CreateCategoryActivity.class);
                startActivity(intent);
            }
        });
        ((Button)root.findViewById(R.id.btnGoToCreateProduct)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),  CreateProductActivity.class);
                startActivity(intent);
            }
        });
        ((Button)root.findViewById(R.id.btnSearchProduct)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchValue = ((EditText) (root.findViewById(R.id.edtSearchProduct))).getText().toString();
                ArrayList searchList = new ArrayList();
                for (int i = 0; i < productList.size() ; i++) {
                    Object product = productList.get(i);
                    if (product.toString().contains(searchValue)) {
                        searchList.add(product);
                    }
                }
                productList.clear();
                productList.addAll(searchList);
                productAdapter.notifyDataSetChanged();
            }
        });

        ProductDAO.currentCategory = "ALL";
        numberOfPage = ProductDAO.numberOfPage;
        pageAdapter = new PageAdapter(getContext(), numberOfPage,this);
        TwoWayView t = (TwoWayView) root.findViewById(R.id.listPage);
        ((TwoWayView)root.findViewById(R.id.listPage)).setAdapter(pageAdapter);
        return root;
    }

    public void setAdapter() {
        productAdapter = new ProductAdapter(getContext(),productList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), MyConfig.spantCount);
        productView.setLayoutManager(mLayoutManager);
        productView.setItemAnimator(new DefaultItemAnimator());
        productView.setAdapter(productAdapter);
    }
    public void changePage() {
        productList.clear();
        productList.addAll(ProductDAO.listOfProduct);
        productAdapter.notifyDataSetChanged();
    }

    public void changListOfPage() {
        pageAdapter = new PageAdapter(getContext(), ProductDAO.numberOfPage,this);
        TwoWayView t = (TwoWayView) root.findViewById(R.id.listPage);
        ((TwoWayView)root.findViewById(R.id.listPage)).setAdapter(pageAdapter);
        changePage();
    }
}
