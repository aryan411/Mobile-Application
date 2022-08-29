package com.example.aryanpatel_comp304_001_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //declare required values
    String exeType;
    ArrayAdapter exeTypeAdapter;
    Spinner exeTypeSpinner;
    List<String> exeTypeArray = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadUI();
    }

    //dynamic population of the UI
    public void loadUI(){
        exeTypeSpinner = (Spinner)findViewById(R.id.exeTypeSpinner);
        exeTypeArray = Arrays.asList(getResources().getStringArray(R.array.exe_type_array));
        // Create Array adapter for food type spinner to bind array data
        exeTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exeTypeArray);
        // Attach the array adapter to the spinner
        exeTypeSpinner.setAdapter(exeTypeAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //retrive items from menu resources file and populate overflow menu
        getMenuInflater().inflate(R.menu.exe_type, menu);
        return true;
    }

    public void onClickBtnNext2(View v){
        String selectedExerciseType = exeTypeSpinner.getSelectedItem().toString();
        Intent i = new Intent(MainActivity.this, Graph.class);
        i.putExtra("exerciseType", selectedExerciseType);
        startActivity(i);
    }


}