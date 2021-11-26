package com.example.mc_revision_all_concepts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.time.Duration;
import java.util.ArrayList;

public class ListViewPractice extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName;
    Button addNameBtn;
    ListView listView;
    ArrayList<String> namesList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_practice);
        editTextName = findViewById(R.id.editTextName);
        addNameBtn = findViewById(R.id.addNameBtn);
        addNameBtn.setOnClickListener(this);
        listView = findViewById(R.id.listView);
        namesList = new ArrayList<String>();
        namesList.add("Ahsan");
        namesList.add("Afaq");
        namesList.add("Faateh");
        namesList.add("Bilal");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,namesList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.addNameBtn:
            {
                String name = editTextName.getText().toString();
                if(!name.equals(""))
                {
                    namesList.add(name);
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Name can't be empty", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
            break;
        }
    }
}