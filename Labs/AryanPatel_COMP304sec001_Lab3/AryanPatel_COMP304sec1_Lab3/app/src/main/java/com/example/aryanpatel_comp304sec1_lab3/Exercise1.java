package com.example.aryanpatel_comp304sec1_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Exercise1 extends AppCompatActivity {

    // object to create frames
    private AnimationDrawable animationD;
    // stop and start buttons
    private Button start, stop;

    // object to display resource
    private ImageView imageV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
    }

    @Override
    protected void onStart(){
        super.onStart();

        // reference for image view
        imageV = (ImageView) findViewById(R.id.imageView);
        // Set background resource
        if (imageV != null) {
            imageV.setBackgroundResource(R.drawable.frames);
        }
        // set start button click action
        start = (Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationD.start();
            }
        });
        // set stop button click action
        stop = (Button)findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                animationD.stop();
            }
        });
        // set background image of imageView to the AnimationDrawable
        animationD = (AnimationDrawable) imageV.getBackground();
        // Stop after one iteration of animation
        animationD.setOneShot(false);
    }
}