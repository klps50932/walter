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

public class GAME extends AppCompatActivity {

    int money,experience,wateraccu,total;
    private int index;
    final static int[] petpic = {R.drawable.pet_egg,R.drawable.horse_1,R.drawable.horse_2,R.drawable.horse_3,R.drawable.horse_4,R.drawable.horse_5,R.drawable.horse_6,
            R.drawable.dragon_1,R.drawable.dragon_2,R.drawable.dragon_3,R.drawable.dragon_4,R.drawable.dragon_5,R.drawable.dragon_6,
            R.drawable.shark_1,R.drawable.shark_2,R.drawable.shark_3,R.drawable.shark_4,R.drawable.shark_5,R.drawable.shark_6};
    private int petexp ;
    ImageView pet;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        ImageView expbar = (ImageView)findViewById(R.id.imageView37);
        pet = (ImageView)findViewById(R.id.imageView23);
        TextView tv_money = (TextView)findViewById(R.id.textView16);
        TextView tv_expbar = (TextView)findViewById(R.id.textView22);
        Test_Data test=new Test_Data(GAME.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
        money = (int)i.getMoney();
        experience = (int)i.getExperience();
        index = (int)i.getPet();
        wateraccu = ((int)i.getWateraccu());
        total = (int) i.getWaterday() ;
        }
        tv_money.setText(String.valueOf(money));

        pet.setImageResource(petpic[index]);
        if (index==6||index==12||index==18)
            petexp =300 + 630*6;
        else
        petexp = 300 + (630*(index%6));

        if (experience == 0)
            expbar.setImageResource(R.drawable.expbar_0);
        else if (experience >= 0 && experience < ((petexp/10)*2))
            expbar.setImageResource(R.drawable.expbar_10);
        else if (experience >= ((petexp/10)*2) && experience < ((petexp/10)*3))
            expbar.setImageResource(R.drawable.expbar_20);
        else if (experience >= ((petexp/10)*3) && experience < ((petexp/10)*4))
            expbar.setImageResource(R.drawable.expbar_30);
        else if (experience >= ((petexp/10)*4) && experience < ((petexp/10)*5))
            expbar.setImageResource(R.drawable.expbar_40);
        else if (experience >= ((petexp/10)*5) && experience < ((petexp/10)*6))
            expbar.setImageResource(R.drawable.expbar_50);
        else if (experience >= ((petexp/10)*6) && experience < ((petexp/10)*7))
            expbar.setImageResource(R.drawable.expbar_60);
        else if (experience >= ((petexp/10)*7) && experience < ((petexp/10)*8))
            expbar.setImageResource(R.drawable.expbar_70);
        else if (experience >= ((petexp/10)*8) && experience < ((petexp/10)*9))
            expbar.setImageResource(R.drawable.expbar_80);
        else if (experience >= ((petexp/10)*9) && experience < petexp)
            expbar.setImageResource(R.drawable.expbar_90);
        else if (experience >= petexp) {
            experience = petexp;
            expbar.setImageResource(R.drawable.expbar_100);
        }
        tv_expbar.setText(String.valueOf(experience) + " / " + String.valueOf(petexp) );
        isNewDay();
    }

    public void toWALK(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(GAME.this,WALK.class));finish();
    }
    public void toWATER(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(GAME.this,WATER.class));finish();
    }
    public void toBAG(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(GAME.this,BAG.class));finish();
    }
    public void toBOOK(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(GAME.this,BOOK.class));finish();
    }
    public void toSHOP(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(GAME.this,SHOP.class));finish();
    }
    public void toACHIEVEMENT(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(GAME.this,ACHIEVEMENT.class));finish();
    }
    public void toEXANGE(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(GAME.this,EXANGE.class));finish();
    }

    private void isNewDay() {
        String time = "00:00";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date curDate = new Date(System.currentTimeMillis()) ;
        String str = formatter.format(curDate);
        if (time==str) {
            total=0;
            Test_Data test=new Test_Data(GAME.this);
            List<Item> items=test.getAll();
            for(Item i:items) {
                i.setWaternow(0);
                i.setWaterday(0);
                test.update(i);
            }
        }
    }
}
