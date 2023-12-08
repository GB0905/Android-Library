package com.example.libraryproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class PassActivity extends AppCompatActivity {
    ImageView qr;
    ToggleButton tb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        qr = (ImageView) this.findViewById(R.id.qrimg);

        tb = (ToggleButton) this.findViewById(R.id.toggleButton);

    }

            public void onToggleClicked(View view) {        //토글버튼 on/off
                if (tb.isChecked()) {
                    qr.setVisibility(View.VISIBLE);
                    qr.setImageResource(R.drawable.qrcode);
                    Toast.makeText(getApplicationContext(), "QR코드를 활성화 하였습니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    qr.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "QR코드를 비활성화 하였습니다", Toast.LENGTH_SHORT).show();
                }
            }




}
