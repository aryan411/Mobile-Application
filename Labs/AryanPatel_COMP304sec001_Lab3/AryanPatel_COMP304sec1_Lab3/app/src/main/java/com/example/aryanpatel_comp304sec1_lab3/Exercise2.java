package com.example.aryanpatel_comp304sec1_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class Exercise2 extends AppCompatActivity {

    // start and stop button
    ToggleButton startStopButton;
    // image view object for rocket
    ImageView rocketIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        // set up rocket image view
        rocketIV = findViewById(R.id.rocket);
        rocketIV.setImageResource(R.drawable.rocket);

        // set up start stop button
        startStopButton = (ToggleButton) findViewById(R.id.toggleButton2);
        startStopButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
                    startStopFrames(value);
            }
        });
    }
    // start or stop rocket function
    private void startStopFrames(boolean val) {
        if(val) {
            Animation rocketAnimation = AnimationUtils.loadAnimation(this, R.anim.rocket_animation);
            rocketAnimation.setRepeatCount(-1);
            rocketAnimation.setRepeatMode(Animation.RESTART);
            rocketIV.startAnimation(rocketAnimation);
        }
        else
        {
            this.rocketIV.clearAnimation();
        }

    }


}