package com.example.dixithihoriya_comp304sec001_lab1_ex2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LifecycleActivity extends AppCompatActivity {

    String outputString = "";
    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle_activity);
        outputString += "onCreate Invoked" + "\n";
        textViewOutput = findViewById(R.id.textView);
        textViewOutput.setText(outputString);
    }

    public void onStart()
    {
        super.onStart();
        outputString += "onStart Invoked" + "\n";
        textViewOutput.setText(outputString);
    }

    public void onRestart()
    {
        super.onRestart();
        outputString += "onRestart Invoked" + "\n";
        textViewOutput.setText(outputString);
    }
    public void onResume()
    {
        super.onResume();
        outputString += "onResume Invoked" + "\n";
        textViewOutput.setText(outputString);
    }
    public void onPause()
    {
        super.onPause();
        outputString += "onPause Invoked" + "\n";
        textViewOutput.setText(outputString);
    }
    //
    public void onStop()
    {
        super.onStop();
        outputString += "onStart Stoped" + "\n";
        textViewOutput.setText(outputString);
    }
    public void onDestroy()
    {
        super.onDestroy();
        outputString += "onDestory Invoked" + "\n";
        textViewOutput.setText(outputString);
    }
}