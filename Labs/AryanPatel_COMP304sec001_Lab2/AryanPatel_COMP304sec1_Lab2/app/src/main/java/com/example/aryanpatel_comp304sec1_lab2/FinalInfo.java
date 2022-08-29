package com.example.aryanpatel_comp304sec1_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalInfo extends AppCompatActivity {
    // Previous bundle values
    String foodTypeSelected, cName, cAddress, cPhoneNo, cEmailAddress, item1, item2, item3;
    String customerInfo = "";

    // Strings to hold values from this view's
    String customerOder = "";
    // UI views
    TextView foodTypeLabel, customerDetails, orderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_info);

        // Grab previously saved values
        Bundle extras = getIntent().getExtras();
        foodTypeSelected = getIntent().getStringExtra("foodTypeSelected");


        // Grab customer information
        if (extras.containsKey("cName")) {
            cName = extras.getString("cName");
        }
        if (extras.containsKey("cAddress")) {
            cAddress = extras.getString("cAddress");
        }
        if (extras.containsKey("cPhoneNo")) {
            cPhoneNo = extras.getString("cPhoneNo");
        }
        if (extras.containsKey("cEmailAddress")) {
            cEmailAddress = extras.getString("cEmailAddress");
        }

        // Grab order items
        if (extras.containsKey("item1")) {
            item1 = extras.getString("item1");
        }
        if (extras.containsKey("item2")) {
            item2 = extras.getString("item2");
        }
        if (extras.containsKey("item3")) {
            item3 = extras.getString("item3");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadUI();
    }

    //loading values into our UI
    private void loadUI() {
        //Grabbing values from our UI elements
        foodTypeLabel = (TextView) findViewById(R.id.food_type_name);
        customerDetails = (TextView) findViewById(R.id.cinfo);
        orderItems = (TextView) findViewById(R.id.tvFoods);

        // Create custom string for order items

        if (cName != null) {
            customerInfo += "Name:" + cName + "\n";
        }
        if (cAddress != null) {
            customerInfo += "Address:" + cAddress + "\n";
        }
        if (cPhoneNo != null) {
            customerInfo += "Phone Number:" + cPhoneNo + "\n";
        }
        if (cEmailAddress != null) {
            customerInfo += "Email Address:" + cEmailAddress + "\n";
        }
        customerDetails.setText(customerInfo);

        // Set UI Values from bundle
        foodTypeLabel.setText(foodTypeSelected);

        if (item1 != null) {
            customerOder += item1 + "\n";
        }
        if (item2 != null) {
            customerOder += item2 + "\n";
        }
        if (item3 != null) {
            customerOder += item3;
        }
        orderItems.setText(customerOder);
    }
}