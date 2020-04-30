package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BAG2 extends AppCompatActivity {


    int good2,experience;
    TextView tv_good2;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag2);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        tv_good2 = (TextView)findViewById(R.id.textView4);
        Test_Data test=new Test_Data(BAG2.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            good2 = ((int) i.getGood2());
            experience = ((int) i.getExperience());
        }
        tv_good2.setText(String.valueOf(good2));
    }
    public void toBAG(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(BAG2.this,BAG.class));finish();
    }
    public void use(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_good2 = (TextView)findViewById(R.id.textView4);
        Test_Data test=new Test_Data(BAG2.this);
        List<Item> items=test.getAll();
        if (good2>0){
            good2 = good2 - 1;
            experience = experience + 225;
            tv_good2.setText(String.valueOf(good2));
            Toast toast = Toast.makeText(BAG2.this, "餵食成功!", Toast.LENGTH_LONG);
            toast.show();
            for(Item i:items) {
                i.setGood2(good2);
                i.setExperience(experience);
        test.update(i);
        }
        }
        else {Toast toast = Toast.makeText(BAG2.this, "食物不夠!", Toast.LENGTH_LONG);
        toast.show();}
        }
        }