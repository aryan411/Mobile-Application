package com.example.aryanpatel_comp304sec1_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String exes[] = {"Exercise 1", "Exercise 2", "Exercise 3"};
    ListView lView;
    TextView tView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// set the reference for the list and text view
        tView =(TextView)findViewById(R.id.textView);
        lView = (ListView) findViewById(R.id.list_view1);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exes);
        lView.setAdapter(arrayAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value = arrayAdapter.getItem(position);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, Exercise1.class));break;

                    case 1:
                        startActivity(new Intent(MainActivity.this, Exercise2.class));break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Exercise3.class));break;

                }
            }
        });
    }
}