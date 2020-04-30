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

public class ACH2 extends AppCompatActivity {

    int BTN,wateraccu,ach2,money;
    ImageView btn_exange;
    RelativeLayout l2;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ach2);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態

        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        l2 = (RelativeLayout)findViewById(R.id.r2);
        btn_exange = (ImageView)findViewById(R.id.imageView38);

        Test_Data test=new Test_Data(ACH2.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            wateraccu = ((int) i.getWateraccu());
            ach2 = ((int) i.getAch2());
            money = ((int) i.getMoney());
        }
        if (ach2==0){
            l2.setBackgroundResource(R.drawable.totaldrink_1);
            if (wateraccu <1000)
                btn_exange.setImageResource(R.drawable.btn_ach);
            else
                btn_exange.setImageResource(R.drawable.btn_totaldrink);
        }
        else if (ach2==1){
            l2.setBackgroundResource(R.drawable.totaldrink_2);
            if (wateraccu <3000)
                btn_exange.setImageResource(R.drawable.btn_ach);
            else
                btn_exange.setImageResource(R.drawable.btn_totaldrink);
        }
    }
    public void toACHIEVEMENT(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        startActivity(new Intent(ACH2.this,ACHIEVEMENT.class));finish();
    }

    public void exange(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        if (ach2==0){
            if (wateraccu <1000){
                Toast toast = Toast.makeText(ACH2.this, "無法兌換!", Toast.LENGTH_LONG);
                toast.show();}
            else {
                money = money + 50;
                Toast toast = Toast.makeText(ACH2.this, "兌換成功!", Toast.LENGTH_LONG);
                toast.show();
                btn_exange.setImageResource(R.drawable.btn_ach);
                l2.setBackgroundResource(R.drawable.totaldrink_2);
                ach2 = 1;
            }
        }
        else if (ach2==1){

            if (wateraccu <3000){
                Toast toast = Toast.makeText(ACH2.this, "無法兌換!", Toast.LENGTH_LONG);
                toast.show();}
            else{
                money = money + 200;
                Toast toast = Toast.makeText(ACH2.this, "兌換成功!", Toast.LENGTH_LONG);
                toast.show();
                btn_exange.setImageResource(R.drawable.btn_ach);
                l2.setBackgroundResource(R.drawable.totaldrink_1);
                ach2 = 0;
            }
        }
        Test_Data test=new Test_Data(ACH2.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            i.setMoney(money);
            i.setAch2(ach2);
            test.update(i);
        }
    }

}
