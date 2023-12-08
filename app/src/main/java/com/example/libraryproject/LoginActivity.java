package com.example.libraryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    Button ok;
    Button no;

    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ok = (Button) findViewById(R.id.ok);
        no = (Button) findViewById(R.id.no);
        phone = (EditText) findViewById(R.id.phone);
    }
    public void onClick(View view){
        ok.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {

                 //입력한 번호가 일치할때 메인액티비티 보여줌
                if(phone.getText().toString().trim().equals("01057377910")){
                    Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();

                    Intent Login = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(Login);

                } else {
                    Toast.makeText(getApplicationContext(), "재입력 하세요", Toast.LENGTH_SHORT).show();
                }

             }

         });
        no.setOnClickListener(new View.OnClickListener(){
            //종료 누르면 꺼짐
             @Override
             public void onClick(View v) {
                 finish();
             }
         });
    }
}