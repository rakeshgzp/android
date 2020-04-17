package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<String> list;
    public RecyclerAdapter(List<String> list)
    {
        this.list = list;
    }

    //It creates object of ViewHolder photo/list/textView item
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //textView will make text_view_layout used as an item
        TextView textView= (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);
        return myViewHolder;
    }

    //We can assign to view component i.e. data in textView
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.VersionName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
//This class responsible for each item in list.
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView VersionName;
        public MyViewHolder(TextView itemView) {
            super(itemView);
            VersionName = itemView;
        }
    }
}
