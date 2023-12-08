package com.example.libraryproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice);

    }
    public void onClick(View view) {
        Button URLbtn = (Button) findViewById(R.id.URLbtn);

        URLbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "홈페이지 이동", Toast.LENGTH_SHORT).show();
                //버튼 누르면 학교 홈페이지로 이동
                Intent URLintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://library.inhatc.ac.kr/Cheetah/Board/Index?Loc=INHA&CategoryId=1&MenuId=S06"));
                startActivity(URLintent);
            }
        });

    }
}
