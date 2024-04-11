package com.example.taskmanager;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper myDB;
    private Button addButton, deleteButton, showAllButton, updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(MainActivity.this);

        addButton = findViewById(R.id.addbtn);
        deleteButton = findViewById(R.id.deletebtn);
        showAllButton = findViewById(R.id.showallbtn);
        updateButton = findViewById(R.id.updatebtn);

        addData();
        updateData();
        deleteData();
        getAllData();

    }
    public void addData(){
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddData.class);
                startActivity(intent);
            }
        });
    }
//Enter Number which will be updated, it will contain 2 textField one for number and one for Task
    public void updateData(){
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateTask.class);
                startActivity(intent);
            }
        });
    }
//Enter number which will be deleted form the database
    public void deleteData(){
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeleteTask.class);
                startActivity(intent);
            }
        });
    }

    public void getAllData(){
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = myDB.getAllData();
                if(!cursor.moveToNext()){
                    Toast.makeText(MainActivity.this,"No Data Exists!", Toast.LENGTH_SHORT).show();


                } else{
                Intent intent = new Intent(MainActivity.this, ViewData.class);
                startActivity(intent);
                }
            }

        });
    }
}



