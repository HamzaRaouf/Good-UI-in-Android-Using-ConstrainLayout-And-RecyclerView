package com.example.myuitask.fragmens;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuitask.R;
import com.example.myuitask.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MonthlyAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    List<Transaction> list;
    HomeFragment fragment;

    public MonthlyAdaptor(Activity context, HomeFragment fragment, List<Transaction> list) {
        this.context = context;
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.monthly_transaction_item, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;

        Transaction data = list.get(position);

        viewHolder.category.setText(data.getTransactionCategory());
        viewHolder.tvDate.setText(data.getDatee());
        viewHolder.tvBalance.setText("+"+data.getAmount());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<Transaction> list) {
        this.list = new ArrayList<>();
        this.list = list;
        notifyDataSetChanged();
    }

    static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvBalance,category;
//        ConstraintLayout layoutBg;
        ImageView img;


        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image);
            tvDate = itemView.findViewById(R.id.date);
            tvBalance = itemView.findViewById(R.id.amount);
            category = itemView.findViewById(R.id.payment_category);
        }
    }
}