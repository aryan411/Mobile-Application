package com.example.dixithihoriya_aryanpatel_comp304sec001_lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentDirectory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdirectory);
    }


    public void addStudentButtonClick(View view)
    {
        Intent intent = new Intent(this, AddStudent.class);
        startActivity(intent);
    }

    public void displayStudentButtonClick(View view)
    {
        Intent intent = new Intent(this, DisplayStudent.class);
        startActivity(intent);
    }
}