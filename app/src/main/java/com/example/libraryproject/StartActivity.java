
package com.example.libraryproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startapp);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); //로딩시간 3초
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}

/*
 * Copyright (c) 2022. [곽권빈]. All rights reserved.
 * Create by [인하공전_컴퓨터시스템과_201945025_곽권빈] on 2022. 6. 10.
 */