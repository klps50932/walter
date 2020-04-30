package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class START extends AppCompatActivity {

    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
    private MediaPlayer mp1;

    int login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態



        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

            mp1 = new MediaPlayer();
            mp1 = MediaPlayer.create(START.this, R.raw.bg); //為MediaPlayer設定音樂
            mp1.setLooping(true); //設定是否重複播放
            mp1.start();



    }

    public void toCREATACCOUNT(View v) {


        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效

        Test_Data test=new Test_Data(START.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            login = ((int) i.getLogin());
            }
        if (login == 0)
        startActivity(new Intent(START.this,CREATACCOUNT.class));
        else
            startActivity(new Intent(START.this,GAME.class));
    }

}
