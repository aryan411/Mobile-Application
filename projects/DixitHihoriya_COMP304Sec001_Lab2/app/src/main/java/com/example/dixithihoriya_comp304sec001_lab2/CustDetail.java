package com.example.dixithihoriya_comp304sec001_lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustDetail extends AppCompatActivity {

    // Previous bundle values
    String foodTypeSelected, item1, item2, item3;
    String customerOder = "";
    EditText customerName, customerAddress, customerPhoneNo, customerEmailAddress;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cust_detail);

        // Grab previously saved values
        Bundle extras = getIntent().getExtras();
        foodTypeSelected = getIntent().getStringExtra("foodTypeSelected");
        customerOder = getIntent().getStringExtra("orderDetails");
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

    //Links UI elements from previous activities data
    private void loadUI(){
        submitBtn = (Button)findViewById(R.id.btnSubmit);
        customerName = (EditText)findViewById(R.id.customer_name);
        customerAddress = (EditText)findViewById(R.id.customer_address);
        customerPhoneNo = (EditText)findViewById(R.id.customer_phoneno);
        customerEmailAddress = (EditText)findViewById(R.id.customer_emailaddress);
    }

    public void submitBtnClicked(View v){
        Intent i = new Intent(CustDetail.this, FinalInfo.class);

        i.putExtra("foodTypeSelected", foodTypeSelected);
        i.putExtra("customerOder", customerOder);
        i.putExtra("item1", item1);
        i.putExtra("item2", item2);
        i.putExtra("item3", item3);
        setExtrasFromCustomerInfo(i);
        startActivity(i);
    }

    private void setExtrasFromCustomerInfo(Intent intent){
        intent.putExtra("cName", customerName.getText().toString());
        intent.putExtra("cAddress", customerAddress.getText().toString());
        intent.putExtra("cPhoneNo", customerPhoneNo.getText().toString());
        intent.putExtra("cEmailAddress", customerEmailAddress.getText().toString());
    }
}
