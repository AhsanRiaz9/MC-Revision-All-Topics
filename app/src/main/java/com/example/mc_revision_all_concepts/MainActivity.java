package com.example.mc_revision_all_concepts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button layoutBtn, inputFieldsBtn,intentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutBtn = findViewById(R.id.layoutBtn);
        inputFieldsBtn = findViewById(R.id.inputFieldsBtn);
        intentBtn = findViewById(R.id.intentBtn);
        layoutBtn.setOnClickListener(this);
        inputFieldsBtn.setOnClickListener(this);
        intentBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.layoutBtn:
            {
                Intent intent = new Intent(MainActivity.this,LayoutPractice.class);
                startActivity(intent);
            }
            break;
            case R.id.inputFieldsBtn:
            {
                Intent intent = new Intent(MainActivity.this,InputFieldsPractice.class);
                intent.putExtra("name","Ahsan Riaz");
                startActivity(intent);
            }
            break;
            case R.id.intentBtn:
            {
                Intent intent = new Intent(MainActivity.this,Intent_Practice.class);
                startActivity(intent);
            }
            break;
        }
    }
}