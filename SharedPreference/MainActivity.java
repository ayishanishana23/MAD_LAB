package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText username,mobile,email,pass1,pass2;
     Button submit;
     SharedPreferences sharedPreferences;
     SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.ed1);
        mobile=findViewById(R.id.ed2);
        email=findViewById(R.id.ed3);
        pass1=findViewById(R.id.ed4);
        pass2=findViewById(R.id.ed5);
        submit=findViewById(R.id.b1);

        sharedPreferences = getSharedPreferences("UserDetails",MODE_PRIVATE);
        editor= sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames= username.getText().toString().trim();
                String mobiles=mobile.getText().toString().trim();
                String emails=email.getText().toString().trim();
                String pass1s=pass1.getText().toString().trim();
                String pass2s=pass2.getText().toString().trim();

                if(usernames.isEmpty()){
                    username.setError("Username is empty");
                    username.requestFocus();
                    return;
                }
                if(mobiles.isEmpty()){
                    mobile.setError("mobile no is empty");
                    mobile.requestFocus();
                    return;
                }
                if(emails.isEmpty()){
                    email.setError("input email");
                    email.requestFocus();
                    return;
                }
                if(pass1s.isEmpty()){
                    pass1.setError("Enter password");
                    pass1.requestFocus();
                    return;
                }
                if(pass2s.isEmpty()){
                    pass2.setError("confirm  password");
                    pass2.requestFocus();
                    return;
                }
                if(pass1s.length()<6){
                    pass1.setError("length must be min 6 characters");
                    pass1.requestFocus();
                    return;
                }
                if(!pass1s.equals(pass2s)){
                    pass2.setError("password not matched ");
                    pass2.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                editor.putString("keyusername", usernames);
                editor.putString("keymobile", mobiles);
                editor.putString("keyemail",emails);
                editor.putString("keypassword",pass2s);
                editor.apply();






            }
        });

    }
}
