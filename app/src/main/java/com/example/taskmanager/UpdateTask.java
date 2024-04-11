package com.example.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateTask extends AppCompatActivity {

    private Button updateBtn;
    private EditText uId, uTask;
    private DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);

        uId = findViewById(R.id.editTextText2);
        uTask = findViewById(R.id.editTextText3);
        updateBtn = findViewById(R.id.button3);

        myDB = new DatabaseHelper(UpdateTask.this);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (uId.getText().toString().isEmpty()) {
                    uId.setError("This field cannot be empty");
                } else if (uTask.getText().toString().isEmpty()) {
                    uTask.setError("This field cannot be empty");
                } else {

                    boolean isUpdated = myDB.updateData(uId.getText().toString(), uTask.getText().toString());
                    if (isUpdated) {
                        Toast.makeText(UpdateTask.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else
                        Toast.makeText(UpdateTask.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}