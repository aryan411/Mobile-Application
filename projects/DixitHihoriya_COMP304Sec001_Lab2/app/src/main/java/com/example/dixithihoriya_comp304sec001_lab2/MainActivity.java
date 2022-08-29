package com.example.dixithihoriya_comp304sec001_lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnNext1(View v){
        Intent i = new Intent(MainActivity.this, FoodTypes.class);
        //launch next activity
        startActivity(i);
    }
}