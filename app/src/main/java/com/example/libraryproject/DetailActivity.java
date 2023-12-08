package com.example.libraryproject;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.Writer;


public class DetailActivity extends Activity {

    private RatingBar ratingBar;
    private TextView value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView Img = (ImageView)findViewById(R.id.bimage);
        TextView Title = (TextView)findViewById(R.id.ttext);
        TextView Writer = (TextView)findViewById(R.id.wtext);
        TextView Location = (TextView)findViewById(R.id.ltext);
        TextView Rentbook = (TextView) findViewById(R.id.rbtext);

        Intent intent = getIntent(); // 보낸 Intent 가져오기
        Img.setImageResource(intent.getIntExtra("img", 0));
        Title.setText(intent.getStringExtra("title"));
        Writer.setText(intent.getStringExtra("writer"));
        Location.setText(intent.getStringExtra("location"));
        Rentbook.setText(intent.getStringExtra("rentbook"));

        SetupRatingBar();


    }
    public void SetupRatingBar(){
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        value = (TextView)findViewById(R.id.value);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), "별점 : "+rating, Toast.LENGTH_SHORT).show();
                value.setText(String.valueOf(rating));
            }
        });
    }


}

