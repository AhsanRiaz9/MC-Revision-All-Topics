package com.example.mc_revision_all_concepts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button layoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutBtn = findViewById(R.id.layoutBtn);
        layoutBtn.setOnClickListener(this);
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
        }
    }
}