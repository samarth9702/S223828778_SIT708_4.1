package com.example.taskmanager;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView viewId, viewTask;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        viewId = itemView.findViewById(R.id.textViewLayout1);
        viewTask = itemView.findViewById(R.id.textViewLayout2);
    }
}
