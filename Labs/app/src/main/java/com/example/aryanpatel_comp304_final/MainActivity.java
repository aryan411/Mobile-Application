package com.example.aryanpatel_comp304_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText sName,sDName;

    DatabaseReference  sDBReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sName = findViewById(R.id.insertText);
        sDName = findViewById(R.id.deleteText);
        sDBReference = FirebaseDatabase.getInstance().getReference().child("stocks");
    }
    public void insertBClick(View view) {
        String stockName = sName.getText().toString().trim();
        Stock stocks = new Stock(stockName);
        sDBReference.push().setValue(stocks);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void DeleteBClick(View view) {
        String stockName = sDName.getText().toString().trim();
//        Log.d("Hii",sDBReference.child("stocks").orderByChild("stockName").equalTo(stockName).toString());
        Query query=sDBReference.child(stockName);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // remove the value at reference
                dataSnapshot.getRef().removeValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
        Toast.makeText(MainActivity.this, "Stock Deleted", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}