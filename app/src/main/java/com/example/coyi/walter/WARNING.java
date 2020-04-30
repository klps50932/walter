package com.example.coyi.walter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WARNING extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態

        Handler handler = new Handler();
        //當計時結束,跳轉至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent();   //intent實體化
                intent.setClass(WARNING.this, START.class); // 切到頁面2
                startActivity(intent);
                finish();
            }
        },2000);

    }
}
