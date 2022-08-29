package com.example.dixithihoriya_aryanpatel_comp304sec001_lab05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity {

    private EditText textFullName, textAge, textEmail, textPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();
        textFullName = (EditText) findViewById(R.id.fullname);
        textAge = (EditText) findViewById(R.id.age);
        textEmail = (EditText) findViewById(R.id.email);
        textPassword = (EditText) findViewById(R.id.password);
    }

    public void registerButtonClick(View view)
    {

        String fullName = textFullName.getText().toString().trim();
        String age = textAge.getText().toString().trim();
        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        if(fullName.isEmpty())
        {
            textFullName.setError("FullName is required");
            textFullName.requestFocus();
            return;
        }
        if(age.isEmpty())
        {
            textAge.setError("Age is required");
            textAge.requestFocus();
            return;
        }
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

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            User user = new User(fullName, age, email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){

                                                Toast.makeText(RegisterUser.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                            }
                                            else
                                            {
                                                Toast.makeText(RegisterUser.this, "Failed to register, Try Again!", Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    });
                        }
                        else
                        {
                            Toast.makeText(RegisterUser.this, "Failed to register, Try Again!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

        // Redirect to the main page of the app to SignIn
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        }
}
