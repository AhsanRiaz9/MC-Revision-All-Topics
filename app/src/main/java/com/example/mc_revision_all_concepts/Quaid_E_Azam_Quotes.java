package com.example.mc_revision_all_concepts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Quaid_E_Azam_Quotes extends AppCompatActivity {

    TextView quoteText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quaid_eazam_quotes);
        Intent intent = getIntent();
        String quote = intent.getStringExtra("quote");
        quoteText = findViewById(R.id.quoteText);
        quoteText.setText(quote);
    }
}