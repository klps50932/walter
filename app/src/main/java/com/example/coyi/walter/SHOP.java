package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SHOP extends AppCompatActivity {

    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);
    }
    public void toGOOD1(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(SHOP.this,GOOD1.class));finish();
    }
    public void toGOOD2(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(SHOP.this,GOOD2.class));finish();
    }
    public void toGOOD3(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(SHOP.this,GOOD3.class));finish();
    }
    public void toGOOD4(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(SHOP.this,GOOD4.class));finish();
    }
    public void toGOOD5(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(SHOP.this,GOOD5.class));finish();
    }
    public void toGOOD6(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(SHOP.this,GOOD6.class));finish();
    }
    public void toGAME(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(SHOP.this,GAME.class));finish();
    }
}
