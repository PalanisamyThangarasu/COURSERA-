package com.example.persistencestorageapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button saveButton;
    private Button loadButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.saveButton);
        loadButton = findViewById(R.id.loadButton);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        saveButton.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("myData", editText.getText().toString());
            editor.apply();
        });

        loadButton.setOnClickListener(view -> {
            String data = sharedPreferences.getString("myData", "");
            editText.setText(data);
        });
    }
}