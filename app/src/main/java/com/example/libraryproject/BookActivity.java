package com.example.libraryproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class BookActivity extends AppCompatActivity {
    ArrayList<Books> bl = new ArrayList<Books>(); //도서 목록을 담을 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //도서목록 데이터 넣기
        bl.add(new Books(R.drawable.book1, "안드로이드 프로그래밍", "천인국 | 생능 | 2022", "005.268 천691ㅇ", "대출 가능"));
        bl.add(new Books(R.drawable.book2, "C# 프로그래밍", "윤인성 | 한빛아카데미 | 2021", "005.133 윤691ㅆ", "대출 가능"));
        bl.add(new Books(R.drawable.book3, "명품 자바 에센셜", "황기태 | 생능 | 2018", "005.133 황18ㅁ", "대출 불가능"));
        bl.add(new Books(R.drawable.book4, "데이터 통신", "정진욱 | 생능 | 2017", "004.6 정79ㄷ", "대출 가능"));
        bl.add(new Books(R.drawable.book5, "데이터베이스 개론과 실습", "박우창 | 한빛아카데미 | 2020", "005.74 박67ㄷ", "대출 불가능"));
        bl.add(new Books(R.drawable.book6, "컴퓨터 구조론", "김종현 | 생능 | 2019", "004.22 김751ㅋ", "대출 가능"));
        bl.add(new Books(R.drawable.book7, "IoT 임베디드오픈플랫폼", "박필준 | WikiDocs | 2019", "621.381 박899ㄷ", "분실"));
        bl.add(new Books(R.drawable.book8, "MOMO", "Michael Ende | 비룡소 | 1999", "833.3 엔23ㅎ", "대출 가능"));
        //도서 이미지 출처 : 교보문고
        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.bookitem, bl);
                                                    //현재화면 제어, 리스트뷰의 레이아웃, 데이터

        ListView list = (ListView) findViewById(R.id.booklist);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                Toast.makeText(getBaseContext(), "도서정보 보기", Toast.LENGTH_SHORT).show();
                // 리스트뷰를 클릭하면 인텐트 생성 > position 값을 통해 인텐트로 값 넘김
                intent.putExtra("img", bl.get(position).img);
                intent.putExtra("title", bl.get(position).title);
                intent.putExtra("writer", bl.get(position).writer);
                intent.putExtra("location", bl.get(position).location);
                intent.putExtra("rentbook", bl.get(position).rentbook);

                startActivity(intent);
            }
        });

    }
}





