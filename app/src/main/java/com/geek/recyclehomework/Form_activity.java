package com.geek.recyclehomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Form_activity extends AppCompatActivity {

    EditText name, surname;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_activity);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        save = findViewById(R.id.btn_save);

        save.setOnClickListener(v -> {

            Intent intent = new Intent();
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("surname", surname.getText().toString());
            setResult(RESULT_OK, intent);
            finish();

        });
    }
}