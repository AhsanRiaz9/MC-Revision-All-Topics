package com.example.mc_revision_all_concepts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputFieldsPractice extends AppCompatActivity {

    TextView welcomeText;
    Button loginBtn;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_fields_practice);
        welcomeText = findViewById(R.id.welcomeText);
        Intent intent = getIntent();
        welcomeText.setText("Hi, " + intent.getStringExtra("name"));
        loginBtn = findViewById(R.id.loginBtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String psw = password.getText().toString();
                if (user.equals("admin") && psw.equals("pakistan123")) {
                        AlertDialog.Builder builder = builder = new AlertDialog.Builder(InputFieldsPractice.this);
                        // Set the message show
                        builder.setMessage("Message you want to show");
                        // Set Alert Title
                        builder.setTitle("Alert !").show();
                    Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}