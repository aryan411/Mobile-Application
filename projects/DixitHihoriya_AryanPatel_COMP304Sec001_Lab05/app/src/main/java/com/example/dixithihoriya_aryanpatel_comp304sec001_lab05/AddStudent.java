package com.example.dixithihoriya_aryanpatel_comp304sec001_lab05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudent extends AppCompatActivity {

    EditText studentName, studentID;

    DatabaseReference studentDBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studentName = findViewById(R.id.stdname);
        studentID   = findViewById(R.id.stid);

        studentDBRef = FirebaseDatabase.getInstance().getReference().child("students");
    }

    public void addButtonClick(View view)
    {
        String stName = studentName.getText().toString().trim();
        String stID = studentID.getText().toString().trim();

        Students students = new Students(stName,stID);
        studentDBRef.push().setValue(students);

        Toast.makeText(AddStudent.this,"Student Added", Toast.LENGTH_SHORT).show();


        // Redirect to the student directory page of the app
        Intent intent = new Intent(this, StudentDirectory.class);
        startActivity(intent);
    }
}