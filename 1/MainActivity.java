package com.example.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText user=findViewById(R.id.user);
        EditText email=findViewById(R.id.email);
        EditText phone=findViewById(R.id.phone);
        EditText pass1=findViewById(R.id.pass1);
        EditText pass2=findViewById(R.id.pass2);
        Button submit=findViewById(R.id.submit);
        sharedPreferences=getSharedPreferences("User_Details",MODE_PRIVATE);
        editor= sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String username=user.getText().toString().trim();
                String phones=phone.getText().toString().trim();
                String emails=email.getText().toString().trim();
                String pass1s=pass1.getText().toString().trim();
                String pass2s= pass2.getText().toString().trim();

                if(username.isEmpty()){
                    user.setError("username is empty");
                    user.requestFocus();
                    return;
                }
                if(phones.isEmpty()){
                    phone.setError("phone is empty");
                    phone.requestFocus();
                    return;
                }
                if(emails.isEmpty()){
                    email.setError("email is empty");
                    email.requestFocus();
                    return;
                }
                if(pass1s.isEmpty()){
                    pass1.setError("password is empty");
                    pass1.requestFocus();
                    return;
                }
                if(pass2s.isEmpty()){
                    pass2.setError("confirm password is empty");
                    pass2.requestFocus();
                    return;
                }
                if(!pass1s.equals(pass2s)){
                    pass2.setError("password does not match");
                    pass2.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this,"Registration success",Toast.LENGTH_SHORT).show();
                editor.putString("username",username);
                editor.putString("phone",phones);
                editor.putString("email",emails);
                editor.putString("password",pass2s);
                editor.apply();

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }



        });



    }
}
