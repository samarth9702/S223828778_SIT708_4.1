package com.example.taskmanager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeleteTask extends AppCompatActivity {
    private EditText deleteId;
    private Button deleteButton;
    private DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_task);

        myDB = new DatabaseHelper(DeleteTask.this);

        deleteId = findViewById(R.id.editTextText);
        deleteButton = findViewById(R.id.button2);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = deleteId.getText().toString();
                if(id.isEmpty()){
                    deleteId.setError("Please Enter Task ID");
                    return;
                }
                Integer var = myDB.deleteData(id);

                if(var > 0){
                    Toast.makeText(DeleteTask.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                    finish();
                }else
                    Toast.makeText(DeleteTask.this, "Deletion Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}