package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView userText = findViewById(R.id.textUser);
        TextView emailText = findViewById(R.id.textEmail);
        TextView phoneText = findViewById(R.id.textPhone);

        SharedPreferences sharedPreferences = getSharedPreferences("User_Details", MODE_PRIVATE);

        String username = sharedPreferences.getString("username", "N/A");
        String email = sharedPreferences.getString("email", "N/A");
        String phone = sharedPreferences.getString("phone", "N/A");

        userText.setText("Username: " + username);
        emailText.setText("Email: " + email);
        phoneText.setText("Phone: " + phone);

    }
}
