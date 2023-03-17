package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class NextActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvAge;
    TextView tvGender;
    TextView tvAddress;
    Button closeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        tvAddress = findViewById(R.id.tvAddress);
        closeButton = findViewById(R.id.buttonClose);

        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("name"));

        tvAge.setText(intent.getStringExtra("age"));

        tvGender.setText(intent.getStringExtra("gender"));

        tvAddress.setText(intent.getStringExtra("address"));

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                for (ActivityManager.AppTask appTask : appTasks) {
                    appTask.finishAndRemoveTask();
                }
            }
        });



    }
}