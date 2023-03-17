package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button submitButton;
    EditText etName;
    EditText etAddress;
    EditText etAge;
    RadioGroup radioGroupGender;
    RadioButton rbMale;
    RadioButton rbFemale;
    String gender = "";
    String name = "";
    String age = "";
    String address = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        submitButton = findViewById(R.id.buttonSubmit);
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etAge = findViewById(R.id.etAge);
        radioGroupGender = findViewById(R.id.radioGroup);
        rbMale = findViewById(R.id.radioMale);
        rbFemale = findViewById(R.id.radioFemale);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    Toast.makeText(MainActivity2.this, "Name is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etAddress.getText().toString())) {
                    Toast.makeText(MainActivity2.this, "Address is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etAge.getText().toString())) {
                    Toast.makeText(MainActivity2.this, "Age is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioGroupGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity2.this, "Select any one gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    Integer.parseInt(etAge.getText().toString());
                } catch (Exception ex) {
                    Toast.makeText(MainActivity2.this, "Age must be a number", Toast.LENGTH_SHORT).show();
                    return;
                }
                name = etName.getText().toString();
                age = etAge.getText().toString();
                address = etAddress.getText().toString();
                Intent intent = new Intent(MainActivity2.this, NextActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                intent.putExtra("address", address);
                intent.putExtra("gender", gender);
                startActivity(intent);

            }
        });

        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radioGroupGender.getCheckedRadioButtonId() == R.id.radioMale) {
                    gender = "Male";
                }
                if (radioGroupGender.getCheckedRadioButtonId() == R.id.radioFemale) {
                    gender = "Female";
                }
            }
        });

    }
}