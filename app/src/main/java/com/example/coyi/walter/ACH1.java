package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

public class ACH1 extends AppCompatActivity {

    int moneyaccu,waterday,ach1=0,achievement=0;
    int BTN;
    ImageView btn_exange;
    RelativeLayout r1;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ach1);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        btn_exange = (ImageView)findViewById(R.id.imageView38);
        r1 = (RelativeLayout)findViewById(R.id.rl_ach);

        Test_Data test=new Test_Data(ACH1.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            waterday = ((int)i.getWaterday());
            moneyaccu = ((int) i.getMoney());
            ach1 = ((int)i.getAch1());
            achievement=((int)i.getAchievement1());
            if (waterday>0)
                achievement = 1;
            i.setAchievement1(achievement);
            test.update(i);
        }
        if (ach1==0)
            r1.setBackgroundResource(R.drawable.drinkgoal_1);
        else if (ach1==1)
            r1.setBackgroundResource(R.drawable.drinkgoal_2);
        if (achievement==1)
            btn_exange.setImageResource(R.drawable.btn_drinkgoal);
        else if (achievement==0)
            btn_exange.setImageResource(R.drawable.btn_ach);

    }

    public void toACHIEVEMENT(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(ACH1.this,ACHIEVEMENT.class));
    }

    public void exange(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);

        if ((achievement==1)&& ach1==0){
            ach1 = 1;
            moneyaccu = moneyaccu + 50;
            achievement =0;
            Toast toast = Toast.makeText(ACH1.this, "兌換成功!", Toast.LENGTH_LONG);
            toast.show();
            btn_exange.setImageResource(R.drawable.btn_ach);
            r1.setBackgroundResource(R.drawable.drinkgoal_1);

        }
        else if ((achievement==1)&& ach1==1){
            ach1 = 0;
            moneyaccu = moneyaccu + 200;
            achievement =0;
            Toast toast = Toast.makeText(ACH1.this, "兌換成功!", Toast.LENGTH_LONG);
            toast.show();
            btn_exange.setImageResource(R.drawable.btn_ach);
            r1.setBackgroundResource(R.drawable.drinkgoal_2);
        }



        Test_Data test=new Test_Data(ACH1.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            i.setMoney(moneyaccu);
            i.setAch1(ach1);
            i.setAchievement1(achievement);
            test.update(i);
        }
    }
}
