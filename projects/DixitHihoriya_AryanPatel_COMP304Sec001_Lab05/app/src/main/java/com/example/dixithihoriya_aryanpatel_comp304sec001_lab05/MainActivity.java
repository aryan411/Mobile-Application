package com.example.dixithihoriya_aryanpatel_comp304sec001_lab05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText textEmail, textPassword;
    private Button signIn;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        textEmail = (EditText) findViewById(R.id.email);
        textPassword = (EditText) findViewById(R.id.password);
    }

    public void signUpButtonClick(View view)
    {
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);
    }

    public void signInButtonClick(View view) {

        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        if(email.isEmpty())
        {
            textEmail.setError("Email Address is required");
            textEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            textEmail.setError("Please provide valid Email Address");
            textEmail.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            textPassword.setError("Password is required");
            textPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent intent = new Intent(MainActivity.this, StudentDirectory.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}