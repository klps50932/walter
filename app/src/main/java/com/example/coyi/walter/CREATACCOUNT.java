package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CREATACCOUNT extends AppCompatActivity {
    private EditText ed_name; //宣告EditText
    private EditText ed_weight; //宣告EditText
    long examount;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_account);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);

    }
    public void toGAME(View v) {

        ed_name = (EditText)findViewById(R.id.ed_name);
        ed_weight = (EditText)findViewById(R.id.ed_weight);
        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup1);
        String name = ed_name.getText().toString();
        String weight = ed_weight.getText().toString();
        sound.play(BTN, 1, 1, 0, 0, 1);

        if (name.matches("") || weight.matches("")){
            Toast toast = Toast.makeText(CREATACCOUNT.this, "請輸入資料", Toast.LENGTH_LONG);
            toast.show();
        }


        else {

            //依選取項目顯示不同訊息
            switch(rg.getCheckedRadioButtonId()){
                case R.id.amount1:
                    examount=1;
                    break;
                case R.id.amount2:
                    examount=2;
                    break;
                case R.id.amount3:
                    examount=3;
                    break;
            }

        // 建立資料庫物件
        Test_Data test=new Test_Data(CREATACCOUNT.this);
        if (test.getCount() == 0) {
            test.sample();
        }
        List<Item> items=test.getAll();

        for(Item i:items){
            i.setLogin(1);
            i.setName(name);
            i.setWeight(Long.parseLong(weight));
            i.setExamount(examount);
            test.update(i);
            startActivity(new Intent(CREATACCOUNT.this,STORY.class));}
    }
    }


}
