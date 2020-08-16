package com.stdio.gridrecyclerview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>{

    private ArrayList<String> list;
    Context context;

    public SimpleAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder holder, int position) {
        holder.tvTitle.setText(list.get(position));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, list.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SimpleViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        RelativeLayout relativeLayout;

        SimpleViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rl);
        }
    }
}