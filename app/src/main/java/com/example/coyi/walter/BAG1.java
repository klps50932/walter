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

public class BAG1 extends AppCompatActivity {

    int good1,experience;
    TextView tv_good1;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag1);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        tv_good1 = (TextView)findViewById(R.id.textView4);
        Test_Data test=new Test_Data(BAG1.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            good1 = ((int) i.getGood1());
            experience = ((int) i.getExperience());
        }
        tv_good1.setText(String.valueOf(good1));
    }
    public void toBAG(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(BAG1.this,BAG.class));finish();
    }
    public void use(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_good1 = (TextView)findViewById(R.id.textView4);
        Test_Data test=new Test_Data(BAG1.this);
        List<Item> items=test.getAll();
        if (good1>0){
        good1 = good1 - 1;
        experience = experience + 100;
        tv_good1.setText(String.valueOf(good1));
        Toast toast = Toast.makeText(BAG1.this, "餵食成功!", Toast.LENGTH_LONG);
        toast.show();
            for(Item i:items) {
                i.setGood1(good1);
                i.setExperience(experience);
                test.update(i);
            }
        }
        else {Toast toast = Toast.makeText(BAG1.this, "食物不夠!", Toast.LENGTH_LONG);
            toast.show();}
    }
}
