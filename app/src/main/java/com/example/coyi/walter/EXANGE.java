package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EXANGE extends AppCompatActivity {

    int water,walk,money,moneyaccu, walkspend;
    TextView tv_water,tv_walk,tv_money;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exange);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效
        tv_water = (TextView)findViewById(R.id.textView19);
        tv_walk = (TextView)findViewById(R.id.textView20);
        tv_money = (TextView)findViewById(R.id.textView21);

        Test_Data test=new Test_Data(EXANGE.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            water = ((int) i.getWaternow());
            walkspend = ((int) i.getWalknow());
            walk =  ((int)i.getWalkday() - walkspend );
            moneyaccu = ((int) i.getMoney());
            }

        if (water/3 == walk/10){
            money = 10*(walk/10);
        }
        else if (water/3 > walk/10) {
            money = 10*(walk/10);
        }
        else if (water/3 < walk/10) {
            money = 10*(water/3);
        }
        tv_walk.setText(String.valueOf(walk));
        tv_water.setText(String.valueOf(water));
        tv_money.setText(String.valueOf(money));

    }
    public void EXANGE(View v){
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        if (water/3 == walk/10 && money!=0){
            moneyaccu = moneyaccu + (10*(water/3));
            walkspend = walkspend + (10*(walk/10));
            money = money - (10*(walk/10));
            walk = walk - (10*(walk/10));
            water = water - (3*(water/3));
            Toast toast = Toast.makeText(EXANGE.this, "兌換成功!", Toast.LENGTH_LONG);
            toast.show();

        }
        else if (water/3 > walk/10 && money!=0) {
            moneyaccu = moneyaccu + (10*(walk/10));
            walkspend = walkspend + (10*(walk/10));
            money = money - (10*(walk/10));
            water = water - (3*(walk/10));
            walk = walk - (10*(walk/10));
            Toast toast = Toast.makeText(EXANGE.this, "兌換成功!", Toast.LENGTH_LONG);
            toast.show();
        }
        else if (water/3 < walk/10 && money!=0) {
            moneyaccu = moneyaccu + (10*(water/3));
            walkspend = walkspend + (10*(water/3));
            money = money - (10*(water/3));
            walk = walk - (10*(water/3));
            water = water - (3*(water/3));
            Toast toast = Toast.makeText(EXANGE.this, "兌換成功!", Toast.LENGTH_LONG);
            toast.show();
        }
        //資料庫
        Test_Data test=new Test_Data(EXANGE.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            i.setMoney(moneyaccu);
            i.setWalknow(walkspend);
            i.setWaternow(water);
            test.update(i);

        }

        tv_walk.setText(String.valueOf(walk));
        tv_water.setText(String.valueOf(water));
        tv_money.setText(String.valueOf(money));
    }
    public void toGAME(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(EXANGE.this,GAME.class));finish();
    }
}
