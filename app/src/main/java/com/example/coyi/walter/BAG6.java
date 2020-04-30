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

public class BAG6 extends AppCompatActivity {

    int good6,experience,index;
    TextView tv_good6;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag6);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        tv_good6 = (TextView)findViewById(R.id.textView4);
        Test_Data test=new Test_Data(BAG6.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            good6 = ((int) i.getGood6());
            experience = ((int) i.getExperience());
            index = ((int)i.getPet());
        }
        tv_good6.setText(String.valueOf(good6));
    }
    public void toBAG(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(BAG6.this,BAG.class));finish();
    }
    public void use(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_good6 = (TextView)findViewById(R.id.textView4);
        Test_Data test=new Test_Data(BAG6.this);
        List<Item> items=test.getAll();
        if (good6>0){

        if (index==5||index==6||index==10||index==11||index==17||index==18){

            good6 = good6 - 1;
            experience = 0;
            index = 0;
            tv_good6.setText(String.valueOf(good6));
            Toast toast = Toast.makeText(BAG6.this, "進化成功!", Toast.LENGTH_LONG);
            toast.show();
            for(Item i:items) {
                i.setGood6(good6);
                i.setExperience(experience);
                i.setPet(index);
                test.update(i);
            }
        }
        else {Toast toast = Toast.makeText(BAG6.this, "不可使用彩虹藥水!", Toast.LENGTH_LONG);
            toast.show();}
    }

    else {Toast toast = Toast.makeText(BAG6.this, "藥水不足!", Toast.LENGTH_LONG);
            toast.show();}
    }
}
