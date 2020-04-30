package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class GOOD3 extends AppCompatActivity {

    int good3,money;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good3);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效
    }
    public void toSHOP(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(com.example.coyi.walter.GOOD3.this,SHOP.class));finish();
    }
    public void buy(View v){
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        Test_Data test=new Test_Data(com.example.coyi.walter.GOOD3.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            good3 = ((int) i.getGood3());
            money = ((int) i.getMoney());
        }
        if (money >= 350){
            good3 = good3 + 1;
            money = money - 350;
            //購買成功
            Toast toast = Toast.makeText(com.example.coyi.walter.GOOD3.this, "購買成功!", Toast.LENGTH_LONG);
            toast.show();
        }
        else {Toast toast = Toast.makeText(com.example.coyi.walter.GOOD3.this, "餘額不足!", Toast.LENGTH_LONG);
            toast.show();}
        for(Item i:items) {
            i.setGood3(good3);
            i.setMoney(money);
            test.update(i);
        }
    }
}

