package com.example.aryanpatel_comp304sec1_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderInfo extends AppCompatActivity {

    // Previous bundle values
    String foodTypeSelected, item1, item2, item3;

    // Strings to hold values from this view's
    String customerOder = "";
    // UI views
    TextView orderItems, foodTypeLabel;
    Button newOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);

        // Grab previously saved values
        Bundle extras = getIntent().getExtras();
        foodTypeSelected = getIntent().getStringExtra("foodTypeSelected");
        // Grab order items
        if (extras.containsKey("item1")) {
            item1 = extras.getString("item1");
        } if (extras.containsKey("item2")) {
            item2 = extras.getString("item2");
        } if (extras.containsKey("item3")) {
            item3 = extras.getString("item3");
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadUI();
    }

    //loading values into our UI
    private void loadUI(){
        //Grabbing values from our UI elements
        foodTypeLabel = (TextView)findViewById(R.id.food_type_name);
        orderItems = (TextView)findViewById(R.id.tvFoods);

        // Set UI Values from bundle
        foodTypeLabel.setText(foodTypeSelected);

        // Create custom string for order items

        if (item1 != null){
            customerOder += item1 + "\n";
        } if (item2 != null){
            customerOder += item2 + "\n";
        } if (item3 != null){
            customerOder += item3;
        }
        orderItems.setText(customerOder);
    }

    public void newOrderClick(View v){
        Intent i = new Intent(OrderInfo.this, CustomerDetails.class);
        i.putExtra("foodTypeSelected", foodTypeSelected);
        i.putExtra("item1", item1);
        i.putExtra("item2", item2);
        i.putExtra("item3", item3);
        startActivity(i);
    }
}