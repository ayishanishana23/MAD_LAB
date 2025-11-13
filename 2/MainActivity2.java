package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tvName, tvTotal, tvPercentage;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvName = findViewById(R.id.tvName);
        tvTotal = findViewById(R.id.tvTotal);
        tvPercentage = findViewById(R.id.tvPercentage);
        btnNext = findViewById(R.id.btnNext);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        int total = i.getIntExtra("total", 0);
        float percentage = i.getFloatExtra("percentage", 0);

        tvName.setText("Name: " + name);
        tvTotal.setText("Total Marks: " + total);
        tvPercentage.setText("Percentage: " + percentage + "%");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("name", name);
                intent.putExtra("percentage", percentage);
                startActivity(intent);
            }
        });
    }
}
