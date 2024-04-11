package com.example.taskmanager;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    ArrayList tasks, id;

    public MyAdapter(Context context, ArrayList id, ArrayList tasks) {
        this.context = context;
        this.tasks = tasks;
        this.id = id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.task_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.viewId.setText(String.valueOf(id.get(position)));
        holder.viewTask.setText(String.valueOf(tasks.get(position)));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}


