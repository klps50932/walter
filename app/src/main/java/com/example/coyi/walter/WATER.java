package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WATER extends AppCompatActivity {

    int water=0,total,waterGOAL,waternow,wateraccu;
    TextView tv_waterday,tv_wateradd,tv_watergoal;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        tv_waterday = (TextView)findViewById(R.id.waternow);
        tv_watergoal = (TextView)findViewById(R.id.textView23);
        ImageView buttle = (ImageView)findViewById(R.id.buttle);

        // 建立資料庫物件
        Test_Data test=new Test_Data(WATER.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            waterGOAL = ((int) i.getExamount() * 250) + ((int) i.getWeight() * 30);
            total = (int) i.getWaterday() ;
            waternow = (int)i.getWaternow();
            wateraccu = (int)i.getWateraccu();
        }
        tv_waterday.setText(String.valueOf(total));
        tv_watergoal.setText(String.valueOf(waterGOAL) +" c.c.");
        if (total == 0)
            buttle.setImageResource(R.drawable.buttle_1);
        else if (total >= 100 && total < 700)
            buttle.setImageResource(R.drawable.buttle_2);
        else if (total >= 700 && total < 1300)
            buttle.setImageResource(R.drawable.buttle_3);
        else if (total >= 1300 && total < waterGOAL)
            buttle.setImageResource(R.drawable.buttle_4);
        else if (total >= waterGOAL)
            buttle.setImageResource(R.drawable.buttle_5);

    }
    public void toGAME(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(WATER.this,GAME.class));finish();
    }

    public void add100(View v){
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_wateradd = (TextView)findViewById(R.id.wateradd);
        water = water+100;
        tv_wateradd.setText(String.valueOf(water));

    }
    public void add200(View v){
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_wateradd = (TextView)findViewById(R.id.wateradd);
        water = water+200;
        tv_wateradd.setText(String.valueOf(water));

    }
    public void add300(View v){
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_wateradd = (TextView)findViewById(R.id.wateradd);
        water = water+300;
        tv_wateradd.setText(String.valueOf(water));

    }

    public void drink(View v){
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_waterday = (TextView)findViewById(R.id.waternow);
        tv_wateradd = (TextView)findViewById(R.id.wateradd);
        ImageView buttle = (ImageView)findViewById(R.id.buttle);

        wateraccu = wateraccu + water;
        total = water + total;


            waternow = water + waternow;
            Test_Data test=new Test_Data(WATER.this);
            List<Item> items=test.getAll();
            for(Item i:items) {
                i.setWaterday(total);
                i.setWaternow(waternow);
                i.setWateraccu(wateraccu);
                test.update(i);
            }
            water = 0;
            if (total == 0)
                buttle.setImageResource(R.drawable.buttle_1);
            else if (total >= 100 && total < 700)
                buttle.setImageResource(R.drawable.buttle_2);
            else if (total >= 700 && total < 1300)
                buttle.setImageResource(R.drawable.buttle_3);
            else if (total >= 1300 && total < waterGOAL)
                buttle.setImageResource(R.drawable.buttle_4);
            else if (total >= waterGOAL)
                buttle.setImageResource(R.drawable.buttle_5);



        tv_waterday.setText(String.valueOf(total));
        tv_wateradd.setText(String.valueOf(water));
    }

    public void cancel(View v){
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_wateradd = (TextView)findViewById(R.id.wateradd);
        water = 0;
        tv_wateradd.setText(String.valueOf(water));

    }


    /**
     * 監聽晚上0點變化初始化數據
     */



}
