package com.example.aryanpatel_comp304sec1_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise3 extends AppCompatActivity {

    // text view
    TextView textV;
    //paint object to store the detail about line
    Paint paint;
    // spinner to select thickness of the line
    Spinner spinner;
    // img view to draw line on
    ImageView drawLine;


    // start and end of x and y exes
    int startx, starty, endx, endy;
    int addToLine = 20;

    // buttons
    Button clearButton;
    ImageButton arrowUp, arrowDown, arrowLeft, arrowRight;
    RadioButton c1, c2, c3;


    // bit map and canvas object
    Bitmap bitmap;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);
        // set up references
        spinner = (Spinner) findViewById(R.id.spinner);
        textV = (TextView) findViewById(R.id.textViewY);
        clearButton = (Button) findViewById(R.id.button_clear);

        drawLine = (ImageView) findViewById(R.id.Image_draw_lines);


        // create canvas to draw line on
        paint = new Paint();
        bitmap =  Bitmap.createBitmap(400, 488, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        drawLine.setImageBitmap(bitmap);

        // set up listener to select thickness of line
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                paint.setStrokeWidth(Integer.parseInt(getResources().getStringArray(R.array.thickness)[i]));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        setUpRadioButton();
        setUpArrows();
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvas.drawColor(Color.WHITE);
                canvas.drawPoint(0,0,paint);
                startx = 0;
                starty = 0;
                endx = 0;
                endy = 0;
            }
        });

    }
    // how to draw the line
    public void canvasImg(Canvas canvas)
    {
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }
    // set radio buttons
    public void setUpRadioButton()
    {
        c1 = (RadioButton) findViewById(R.id.rbColo1);
        c2 = (RadioButton) findViewById(R.id.rbColor2);
        c3 = (RadioButton) findViewById(R.id.rbColor3);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.RED);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.YELLOW);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.CYAN);
            }
        });
    }
    // draw the lines
    public void setUpArrows()
    {
        arrowUp = (ImageButton) findViewById(R.id.imageButton_up);
        arrowDown = (ImageButton) findViewById(R.id.imageButton_down);
        arrowLeft = (ImageButton) findViewById(R.id.imageButton_left);
        arrowRight = (ImageButton) findViewById(R.id.imageButton_right);

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endy = endy - addToLine;
                canvasImg(canvas);
                drawLine.invalidate();
            }
        });
        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endy = endy + addToLine;
                canvasImg(canvas);
                drawLine.invalidate();
            }
        });
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endx = endx - addToLine;
                canvasImg(canvas);
                drawLine.invalidate();
            }
        });

        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endx = endx + addToLine;
                canvasImg(canvas);
                drawLine.invalidate();
            }
        });

    }

    // erase all lines and turn back to black
    public void clearLines(View view)
    {
        canvas.drawColor(Color.BLUE);
        canvas.drawPoint(0,0,paint);
        startx = 0;
        starty = 0;
        endx = 0;
        endy = 0;
    }
}