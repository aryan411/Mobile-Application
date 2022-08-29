package com.example.aryanpatel_comp304sec1_lab2;

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

public class FoodTypes extends AppCompatActivity {

    //declare required values
    String foodType;
    ArrayAdapter foodTypeAdapter;
    Spinner foodTypeSpinner;
    List<String> foodTypeArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_types);
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadUI();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //retrive items from menu resources file and populate overflow menu
        getMenuInflater().inflate(R.menu.foodtype_menu, menu);
        return true;
    }

    public void onClickBtnNext2(View v){
        String selectedFoodType = foodTypeSpinner.getSelectedItem().toString();
        Intent i = new Intent(FoodTypes.this, AddOrder.class);
        i.putExtra("foodType", selectedFoodType);
        startActivity(i);
    }

    //dynamic population of the UI
    public void loadUI(){
        foodTypeSpinner = (Spinner)findViewById(R.id.foodTypeSpinner);
        foodTypeArray = Arrays.asList(getResources().getStringArray(R.array.Fd_Type_Array));

        // Create Array adapter for food type spinner to bind array data
        foodTypeAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, foodTypeArray);

        // Attach the array adapter to the spinner
        foodTypeSpinner.setAdapter(foodTypeAdapter);
    }
}