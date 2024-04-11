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

public class AddData extends AppCompatActivity {
   private DatabaseHelper myDB;
   private EditText editText1;
   private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_data);

        editText1 = findViewById(R.id.editText1);
        addButton = findViewById(R.id.button);
        myDB = new DatabaseHelper(AddData.this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText1.getText().toString().isEmpty() ){
                    editText1.setError("This field cannot be empty");
                } else {

                    boolean isInserted = myDB.insertData(editText1.getText().toString());

                    if (isInserted){
                     Toast.makeText(AddData.this, "Data Inserted...", Toast.LENGTH_SHORT).show();
                        finish();
                    } else
                        Toast.makeText(AddData.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}