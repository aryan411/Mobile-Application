package com.example.dixithihoriya_aryanpatel_comp304sec001_lab05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayStudent extends AppCompatActivity {


    ListView stdListView;
    List<Students> studentsList;

    DatabaseReference studentDBRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);

        stdListView = findViewById(R.id.stdListView);
        studentsList = new ArrayList<>();

        studentDBRef = FirebaseDatabase.getInstance().getReference("students");

        studentDBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentsList.clear();

                for (DataSnapshot studentDatasnap : snapshot.getChildren()){
                    Students students = studentDatasnap.getValue(Students.class);
                    studentsList.add(students);
                }
                ListAdapter adapter = new ListAdapter(DisplayStudent.this,studentsList);
                stdListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        stdListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Students students = studentsList.get(position);
                showDeleteDialog(students.getId());
                return false;
            }
        });
    }

    public void showDeleteDialog(String id){
        AlertDialog.Builder sDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View sDialogView = inflater.inflate(R.layout.delete_dialog, null);

        sDialog.setView(sDialogView);

        Button btnDelete = sDialogView.findViewById(R.id.delete);
        sDialog.setTitle("Deleting Record");
        final AlertDialog alertDialog = sDialog.create();
        alertDialog.show();
    }

    public void deleteButtonClick(View view)
    {
        DatabaseReference DBRef = FirebaseDatabase.getInstance().getReference("students");
        Task<Void> sTask = DBRef.removeValue();

        Toast.makeText(DisplayStudent.this,"Student Record Deleted", Toast.LENGTH_SHORT).show();


        // Redirect to the student directory page of the app
        Intent intent = new Intent(this, StudentDirectory.class);
        startActivity(intent);
    }
}