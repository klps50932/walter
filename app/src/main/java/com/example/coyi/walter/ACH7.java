package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ACH7 extends AppCompatActivity {

    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ach7);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態

        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效
    }

    public void toACHIEVEMENT(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(ACH7.this,ACHIEVEMENT.class));finish();
    }

    public void exange(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);}
}
