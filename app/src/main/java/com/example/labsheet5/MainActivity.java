package com.example.labsheet5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    Button selectAll, add, delete, update, signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        selectAll = findViewById(R.id.selectAllBtn);
        add = findViewById(R.id.addBtn);
        delete = findViewById(R.id.deleteBtn);
        update = findViewById(R.id.updateBtn);
        signin = findViewById(R.id.signinBtn);
    }
}
