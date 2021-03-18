package com.project.asms1.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.project.asms1.R;
import com.project.asms1.model.Order;
import com.project.asms1.model.OrderDTO;
import com.project.asms1.model.User;
import com.project.asms1.presentation.AccountDetailActivity;
import com.project.asms1.presentation.OrderDetailActivity;
import com.project.asms1.presentation.OrderListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suleiman on 19/10/16.
 */

public class ScrollingPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int mode;

    private static final int LOADING = 0;
    private static final int ACCOUNT = 1;
    private static final int ORDER = 2;

    private List<Object> list;
    private Context context;

    private boolean isLoadingAdded = false;

    public ScrollingPageAdapter(Context context, int mode) {
        this.context = context;
        this.mode = mode;
        list = new ArrayList<>();
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ACCOUNT:
                View v1 = inflater.inflate(R.layout.account_list_adapter, parent, false);
                viewHolder = new AccountViewHolder(v1);
//                viewHolder = getViewHolder(parent, inflater);
                break;
            case ORDER:
                View v2 = inflater.inflate(R.layout.item_order_list, parent, false);
                viewHolder = new OrderViewHolder(v2);
                break;
            case LOADING:
                View v3 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingViewHolder(v3);
                break;
        }
        return viewHolder;
    }

//    @NonNull
//    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
//        RecyclerView.ViewHolder viewHolder;
//        View v1 = inflater.inflate(R.layout.account_list_adapter, parent, false);
//        viewHolder = new ViewHolder(v1);
//        return viewHolder;
//    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case ACCOUNT:
                User user = (User) list.get(position);
                AccountViewHolder accountViewHolder = (AccountViewHolder) holder;

                accountViewHolder.textView.setText(user.getName());
                accountViewHolder.layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, AccountDetailActivity.class);
                        intent.putExtra("user", user.getId());
                        context.startActivity(intent);
                    }
                });
                break;
            case ORDER:
                Order order = (Order) list.get(position);
                OrderViewHolder orderViewHolder = (OrderViewHolder) holder;
                orderViewHolder.textViewItemId.setText(order.getID());
                orderViewHolder.textViewItemDate.setText(order.getOrderDate()+" ");
                orderViewHolder.textViewItemStatus.setText(order.getStatus()+"");
                orderViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, OrderDetailActivity.class);
                        intent.putExtra("clicked_order", order);
                        context.startActivity(intent);
                    }
                });
                break;
            case LOADING:
//                Do nothing
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size() - 1 && isLoadingAdded) {
            return LOADING;
        } else if (mode == ACCOUNT) return ACCOUNT;
        else if (mode == ORDER) return ORDER;
        else return -1;
    }

    /*
   Helpers
   _________________________________________________________________________________________________
    */

    public void add(Object object) {
        list.add(object);
        notifyItemInserted(list.size() - 1);
    }

    public void addAll(List<Object> list) {
        for (Object object : list) {
            add(object);
        }
    }

    public void remove(Object object) {
        int position = list.indexOf(object);
        if (position > -1) {
            list.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        // Change this to the class needed
        add(new Object());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = list.size() - 1;
        Object item = getItem(position);

        if (item != null) {
            list.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Object getItem(int position) {
        return list.get(position);
    }


   /*
   View Holders
   _________________________________________________________________________________________________
    */

    /**
     * Main list's content ViewHolder
     */
    protected class AccountViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private LinearLayout layout;

        public AccountViewHolder(View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.accountLayoutManageAccountAdapter);
            textView = (TextView) itemView.findViewById(R.id.txtAccountUsernameManageAccountAdapter);
        }
    }

    protected class OrderViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewItemId;
        private TextView textViewItemDate;
        private TextView textViewItemStatus;
        private LinearLayout linearLayout;

        public OrderViewHolder(View itemView) {
            super(itemView);
            textViewItemId = (TextView) itemView.findViewById(R.id.txt_item_ID);
            textViewItemDate = (TextView) itemView.findViewById(R.id.txt_item_date);
            textViewItemStatus = (TextView) itemView.findViewById(R.id.txt_item_status);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.layout_item_order_list);


        }
    }


    protected class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(View itemView) {
            super(itemView);
        }
    }


}