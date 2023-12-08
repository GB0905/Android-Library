package com.example.libraryproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Button b1 = (Button) findViewById(R.id.notice_button);
        Button b2 = (Button) findViewById(R.id.seat_button);
        Button b3 = (Button) findViewById(R.id.book_button);
        Button b4 = (Button) findViewById(R.id.pass_button);

        //공지사항으로 이동
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "공지사항 보기", Toast.LENGTH_SHORT).show();
                Intent noticeintent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(noticeintent);
            }
        });
        //자리예약으로 이동
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "도서관 좌석보기", Toast.LENGTH_SHORT).show();
                Intent seatintent = new Intent(MainActivity.this, SeatActivity.class);
                startActivity(seatintent);
            }
        });
        //도서목록으로 이동
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "도서 목록", Toast.LENGTH_SHORT).show();
                Intent bookintent = new Intent(MainActivity.this, BookActivity.class);
                startActivity(bookintent);
            }
        });
        //모바일 신분증(pass)으로 이동
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "모바일 신분증", Toast.LENGTH_SHORT).show();
                Intent passintent = new Intent(MainActivity.this, PassActivity.class);
                startActivity(passintent);
            }
        });
    }
}



