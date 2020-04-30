package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class GOOD1 extends AppCompatActivity {
    int good1,money;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good1);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效
    }
    public void toSHOP(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(GOOD1.this,SHOP.class));finish();
    }
    public void buy(View v){
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        Test_Data test=new Test_Data(GOOD1.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            good1 = ((int) i.getGood1());
            money = ((int) i.getMoney());
        }
        if (money >= 150){
        good1 = good1 + 1;
        money = money - 150;
        //購買成功
        Toast toast = Toast.makeText(GOOD1.this, "購買成功!", Toast.LENGTH_LONG);
        toast.show();
        }
        else {Toast toast = Toast.makeText(GOOD1.this, "餘額不足!", Toast.LENGTH_LONG);
            toast.show();}
        for(Item i:items) {
            i.setGood1(good1);
            i.setMoney(money);
            test.update(i);
        }
    }
}
