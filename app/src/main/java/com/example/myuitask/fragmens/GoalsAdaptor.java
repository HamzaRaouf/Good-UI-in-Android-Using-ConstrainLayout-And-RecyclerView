package com.example.myuitask.fragmens;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.myuitask.models.Bills;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuitask.R;

import java.util.ArrayList;
import java.util.List;

//public class GoalsAdaptor {
//}




public class GoalsAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    List<Bills> list;
    HomeFragment fragment;

    public GoalsAdaptor(Activity context, List<Bills> list) {
        this.context = context;
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.goals_item, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;

        Bills data = list.get(position);
        if(position % 3 == 0) {
            // For custom Drawable
            Drawable drawable = context.getResources().getDrawable(R.drawable.white_backgroud,null);
            viewHolder.layoutBg.setBackground(drawable);
        } else if(position % 3 == 1) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.light_dark_bg,null);
            viewHolder.layoutBg.setBackground(drawable);
        } else {
            Drawable drawable = context.getResources().getDrawable(R.drawable.bg_new_bg,null);
            viewHolder.layoutBg.setBackground(drawable);
        }

        viewHolder.title.setText(data.getAmount());
        viewHolder.subtText.setText(data.getBillDate());
//        viewHolder.tvTitle.setText(""+(position+1)+" :"+data.name);
//        viewHolder.tvDate.setText(data.getBillDate());
//        viewHolder.tvBalance.setText("$"+data.getAmount());


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
        TextView title;
        TextView subtText;
        ConstraintLayout layoutBg;
//        ImageView check;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
//            check = itemView.findViewById(R.id.check);
            title = itemView.findViewById(R.id.tvTitle);
            subtText = itemView.findViewById(R.id.tv_sbtext);
            layoutBg = itemView.findViewById(R.id.layout_bg);
        }
    }
}