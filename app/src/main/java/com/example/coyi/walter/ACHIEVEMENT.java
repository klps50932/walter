package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ACHIEVEMENT extends AppCompatActivity {

    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

    }
    public void toACH1(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,ACH1.class));finish();
    }
    public void toACH2(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,ACH2.class));finish();
    }
    public void toACH3(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,ACH3.class));finish();
    }
    public void toACH4(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,ACH4.class));finish();
    }
    public void toACH5(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,ACH5.class));finish();
    }
    public void toACH6(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,ACH6.class));finish();
    }
    public void toACH7(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,ACH7.class));finish();
    }
    public void toACH8(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,ACH8.class));finish();
    }
    public void toGAME(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(ACHIEVEMENT.this,GAME.class));finish();
    }

}
