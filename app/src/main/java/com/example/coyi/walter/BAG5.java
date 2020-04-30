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
import java.util.Random;

public class BAG5 extends AppCompatActivity {

    int good5,experience,index,petexp,petindex;
    TextView tv_good5;
    final static int[] pettype = {1, 7, 12};
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag5);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        tv_good5 = (TextView)findViewById(R.id.textView4);
        Test_Data test=new Test_Data(BAG5.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            good5 = ((int) i.getGood5());
            experience = ((int) i.getExperience());
            index = ((int)i.getPet());
        }
        tv_good5.setText(String.valueOf(good5));
    }
    public void toBAG(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(BAG5.this,BAG.class));finish();
    }
    public void use(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        tv_good5 = (TextView)findViewById(R.id.textView4);
        if (index==6||index==12||index==18)
            petexp =300 + 630*6;
        else
            petexp = 300 + (630*(index%6));
        Test_Data test=new Test_Data(BAG5.this);
        List<Item> items=test.getAll();


        if (good5>0 && experience >= petexp){

            if (index==5||index==6||index==10||index==11||index==17||index==18){
                Toast toast = Toast.makeText(BAG5.this, "可能需要彩虹藥水才能進化!", Toast.LENGTH_LONG);
                toast.show();
            }
            else {
            good5 = good5 - 1;
            experience = 0;

            if (index==0){
                Random ran = new Random();
                petindex =ran.nextInt(2);
                index = pettype[petindex];
            }
            else {
            index = index + 1;}

            tv_good5.setText(String.valueOf(good5));
            Toast toast = Toast.makeText(BAG5.this, "進化成功!", Toast.LENGTH_LONG);
            toast.show();
            for(Item i:items) {
                i.setGood5(good5);
                i.setExperience(experience);
                i.setPet(index);
                test.update(i);
            }
            }
        }
        else {Toast toast = Toast.makeText(BAG5.this, "藥水不足!", Toast.LENGTH_LONG);
            toast.show();}
        }

}

