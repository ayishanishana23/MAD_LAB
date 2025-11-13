package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvResult = findViewById(R.id.tvResult);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        float percentage = i.getFloatExtra("percentage", 0);

        if (percentage >= 50) {
            tvResult.setText(name + " is PASS ");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            tvResult.setText(name + " is FAIL ");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }
}
