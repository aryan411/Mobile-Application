package com.example.aryanpatel_comp304_001_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Graph extends AppCompatActivity {

    int color;
    String value, exerciseType;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        exerciseType = getIntent().getStringExtra("exerciseType");
    }

    protected  void onStart(){
        super.onStart();
        loadUI();
    }

    private void loadUI() {

        switch (exerciseType) {
            case "Jumping Rope":
                color = Color.RED;
                value = "750 kcal";
                break;
            case "Swimming":
                color = Color.BLUE;
                value = "600 kcal";
                break;
            case "Bike Riding":
                color = Color.YELLOW;
                value = "500 kcal";
                break;
            case "Walking":
                color = Color.GREEN;
                value = "300 kcal";
                break;
            case "Running":
                color = 0xFF800080;// hexadecimal for purple color
                value = "600 kcal";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + exerciseType);
        }
        ImageView imageView=(ImageView) findViewById(R.id.imageView);



        Bitmap bitmap = Bitmap.createBitmap(900, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        canvas.drawRect(0, 180, 1800, 80, paint);
        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(80);
        canvas.drawText(value,80,150,textPaint);
        imageView.setImageBitmap(bitmap);

        LinearLayout linearLayout= (LinearLayout)findViewById(R.id.linearlayout2);
        linearLayout.setBackgroundColor(color);

        TextView tv= (TextView)findViewById(R.id.tv2);
        tv.setText(exerciseType);

        //TextView tvValue= (TextView)findViewById(R.id.tvValue);
        //tvValue.setText(value);
    }
}