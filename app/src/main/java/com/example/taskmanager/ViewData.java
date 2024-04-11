package com.example.taskmanager;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewData extends AppCompatActivity {

    private DatabaseHelper myDB;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<String> view_id, view_task;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_data);

        recyclerView = findViewById(R.id.recyclerView);

        myDB = new DatabaseHelper(ViewData.this);
        view_task = new ArrayList<>();
        view_id = new ArrayList<>();
        adapter = new MyAdapter(this, view_id, view_task);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displayData();
    }

    private void displayData() {
        Cursor cursor = myDB.getAllData();

            while (cursor.moveToNext()){
                view_id.add(cursor.getString(0));
                view_task.add(cursor.getString(1));
            }
    }
}

