package com.example.mc_revision_all_concepts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.time.Duration;
import java.util.ArrayList;

public class ListViewPractice extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName;
    Button addNameBtn,dilougeAlertBtn;
    ListView listView;
    ArrayList<String> namesList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_practice);
        editTextName = findViewById(R.id.editTextName);
        addNameBtn = findViewById(R.id.addNameBtn);
        dilougeAlertBtn = findViewById(R.id.dilougeAlertBtn);
        addNameBtn.setOnClickListener(this);
        dilougeAlertBtn.setOnClickListener(this);
        listView = findViewById(R.id.listView);
        namesList = new ArrayList<String>();
        namesList.add("Ahsan");
        namesList.add("Afaq");
        namesList.add("Faateh");
        namesList.add("Bilal");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,namesList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = namesList.get(position) + " is selected";
                // context is listViewPractice.this
                Toast.makeText(ListViewPractice.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
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
            case R.id.dilougeAlertBtn:
            {
                AlertDialog.Builder builder = builder = new AlertDialog.Builder(ListViewPractice.this);
                builder.setMessage("Hi").setPositiveButton("yes",(dialog, which) -> {
                   finish();
                }).setNegativeButton("no",(dialog, which) -> {
                    Toast.makeText(ListViewPractice.this, "Hi", Toast.LENGTH_SHORT).show();
                }).setTitle("Alert Dilouge").show();
            }
            break;
        }
    }
}