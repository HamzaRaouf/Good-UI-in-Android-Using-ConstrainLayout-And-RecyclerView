package com.example.myuitask.fragmens;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuitask.R;
import com.example.myuitask.models.Bills;

import java.util.ArrayList;
import java.util.List;

//public class BillsAdaptor {
//}


public class BillsAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    List<Bills> list;
    HomeFragment fragment;

    public BillsAdaptor(Activity context, HomeFragment fragment, List<Bills> list) {
        this.context = context;
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.bill_item, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;

        Bills data = list.get(position);
        if(position % 2 == 0) {
            // For custom Drawable
            Drawable drawable = fragment.getResources().getDrawable(R.drawable.blue_background);
            viewHolder.layoutBg.setBackground(drawable);
        } else {
            Drawable drawable = fragment.getResources().getDrawable(R.drawable.orange_bg);
            viewHolder.layoutBg.setBackground(drawable);
        }
//        viewHolder.tvTitle.setText(""+(position+1)+" :"+data.name);
        viewHolder.tvDate.setText(data.getBillDate());
        viewHolder.tvBalance.setText("$"+data.getAmount());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<Bills> list) {
        this.list = new ArrayList<>();
        this.list = list;
        notifyDataSetChanged();
    }

    static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvBalance;
        ConstraintLayout layoutBg;
//        ImageView check;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
//            check = itemView.findViewById(R.id.check);
            tvDate = itemView.findViewById(R.id.date_tv);
            tvBalance = itemView.findViewById(R.id.tv_balance);
            layoutBg = itemView.findViewById(R.id.layout_bg);
        }
    }
}