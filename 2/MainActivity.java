package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, mark1, mark2, mark3, mark4;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        mark1 = findViewById(R.id.etMark1);
        mark2 = findViewById(R.id.etMark2);
        mark3 = findViewById(R.id.etMark3);
        mark4 = findViewById(R.id.etMark4);
        submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname = name.getText().toString().trim();
                if (sname.isEmpty() || mark1.getText().toString().isEmpty() ||
                        mark2.getText().toString().isEmpty() ||
                        mark3.getText().toString().isEmpty() ||
                        mark4.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int m1 = Integer.parseInt(mark1.getText().toString());
                int m2 = Integer.parseInt(mark2.getText().toString());
                int m3 = Integer.parseInt(mark3.getText().toString());
                int m4 = Integer.parseInt(mark4.getText().toString());

                int total = m1 + m2 + m3 + m4;
                float percentage = (total / 4.0f);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", sname);
                intent.putExtra("total", total);
                intent.putExtra("percentage", percentage);
                startActivity(intent);
            }
        });
    }
}
