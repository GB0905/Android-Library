
package com.example.libraryproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class SeatActivity extends AppCompatActivity {

    Button dr;
    Button s1;
    Button s2;
    private int room; //좌석 상태

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        s1 = findViewById(R.id.seat1); //1번 좌석
        s2 = findViewById(R.id.seat2); //2번 좌석
        dr = findViewById(R.id.dorent); //퇴실 버튼

        dr.setEnabled(false); //좌석 예약이 되야지 퇴실하기 버튼 활성화 되게 구현했습니다.
        Toast.makeText(getApplicationContext(), "원하는 좌석을 선택하세요", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {

        //누른 버튼에 따라 알림메뉴 보여주기
        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dr);
            }
        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(s1);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(s2);
            }
        });

    }

    //room = 1 예약 O
    //room = 0 예약 X

    void showDialog(Button a) {
        AlertDialog.Builder rentBuilder = new AlertDialog.Builder(this);
        rentBuilder.setTitle("이용 안내");

        //1번좌석 예약
        if (a == s1) {
            if (room == 0) {
                rentBuilder.setMessage("1번 좌석을 예약하시겠습니까?" + "\n" + "이용 요금은 1시간 당 2000원 입니다.")
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SeatActivity.this, "1번 좌석이 예약되었습니다.", Toast.LENGTH_SHORT).show();
                                s1.setEnabled(false); //1번 좌석 예약된 상태를 버튼 비활성화로 나타냄
                                s2.setEnabled(true);
                                dr.setEnabled(true);
                                room = 1;
                            }
                        })
                        .setPositiveButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { }
                        });
            } else { //2번 좌석에서 1번 좌석으로 예약 변경 시
                rentBuilder.setMessage("1번 좌석으로 예약을 변경하시겠습니까?" + "\n" + "이용 요금은 1시간 당 2000원 입니다.")
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SeatActivity.this, "1번 좌석으로 변경되었습니다.", Toast.LENGTH_SHORT).show();
                                s1.setEnabled(false); //2번 좌석에서 1번 좌석으로 변경 되었음으로 1번 좌석 비활성화(예약표시)
                                s2.setEnabled(true);
                                dr.setEnabled(true);
                                room = 1;
                            }
                        })
                        .setPositiveButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { }
                        });
            }
        }

        //2번좌석 예약
        else if (a == s2){
            if (room == 0) {
                rentBuilder.setMessage("2번 좌석을 예약하시겠습니까?" + "\n" + "이용 요금은 1시간 당 1500원 입니다.")
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SeatActivity.this, "2번 좌석이 예약되었습니다.", Toast.LENGTH_SHORT).show();
                                s1.setEnabled(true);
                                s2.setEnabled(false);//2번 좌석 예약된 상태
                                dr.setEnabled(true);
                                room = 1;
                            }
                        })
                        .setPositiveButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { }
                        });
            } else { //1번 좌석에서 2번 좌석으로 예약 변경 시
                rentBuilder.setMessage("2번 좌석으로 예약을 변경하시겠습니까?" + "\n" + "이용 요금은 1시간 당 1500원 입니다.")
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SeatActivity.this, "2번 좌석으로 변경되었습니다.", Toast.LENGTH_SHORT).show();
                                s1.setEnabled(true);
                                s2.setEnabled(false); //1번 좌석에서 2번 좌석으로 변경 되었음으로 2번 좌석 비활성화(예약표시)
                                dr.setEnabled(true);
                                room = 1;
                            }
                        })
                        .setPositiveButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { }
                        });
            }
        }

        //퇴실하기
        if (a == dr) {
            rentBuilder.setMessage("퇴실 하시겠습니까?")
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(SeatActivity.this, "퇴실이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                            s1.setEnabled(true);    //퇴실 이후 모든 좌석 활성화
                            s2.setEnabled(true);
                            dr.setEnabled(false);   //퇴실 이후 [퇴실 버튼] 비활성화
                            room = 0; //예약이 없는 상태
                        }
                    })
                    .setPositiveButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) { }
                    });

        }
        AlertDialog rentDlg = rentBuilder.create(); //알림 메뉴 생성
        rentDlg.show(); //알림 메뉴 보여줌
    }
}

