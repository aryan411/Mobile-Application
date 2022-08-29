package com.example.aryanpatel_comp304sec1_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOrder extends AppCompatActivity {
    //Instantiate our values
    List<String> foodArray = new ArrayList<String>();
    String foodTypeSelected;
    TextView foodTypeLabel;
    CheckBox chk1, chk2, chk3;
    Button nextBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the content to display once the activity loads.
        setContentView(R.layout.activity_add_order);

        // Get food preference and shop from previous activity
        foodTypeSelected = getIntent().getStringExtra("foodType");
    }

    @Override
    protected  void onStart(){
        super.onStart();
        loadUI();
    }


    public void onClickBtnNext4(View v){
        Intent i = new Intent(AddOrder.this, OrderInfo.class);
        //Pass values to next activity
//        i.putExtra("foodType", foodType);
        i.putExtra("foodTypeSelected", foodTypeSelected);
        //retrieve data from checkboxes
        setExtrasFromCheckBoxes(i);
        startActivity(i);
    }

    private void loadUI() {
        //links variables to view components
        foodTypeLabel = (TextView) findViewById(R.id.food_type_name);
        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);
        nextBtn4 = (Button) findViewById(R.id.btnNext4);

        // Set food type label text
        foodTypeLabel.setText(foodTypeSelected);

        // Set array to use based on shop selected in previous activity
        switch (foodTypeSelected) {
            case "Fruits and Vegetables":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.Food_Type_1));
                break;
            case "Grains and Cereals":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.Food_Type_2));
                break;
            case "Dairy Foods and Beverages":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.Food_Type_3));
                break;
            case "Meat, Sea Foods and Poultry Foods":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.Food_Type_4));
                break;
            case "Baked Foods":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.Food_Type_5));
                break;
            default:
                break;
        }
        // Set checkbox text based on switch case
        chk1.setText(foodArray.get(0));
        chk2.setText(foodArray.get(1));
        chk3.setText(foodArray.get(2));
    }


    private void setExtrasFromCheckBoxes(Intent intent){
        // Pass all values that are checked to the next activity
        if (chk1.isChecked()){
            intent.putExtra("item1", chk1.getText().toString());
        } if (chk2.isChecked()){
            intent.putExtra("item2", chk2.getText().toString());
        } if (chk3.isChecked()){
            intent.putExtra("item3", chk3.getText().toString());
        }
    }
}